package com.fadegor05.cubefear.fear

import com.fadegor05.cubefear.effects.ModEffects
import com.fadegor05.cubefear.forces.ModForces
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.damage.DamageSources
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import kotlin.math.abs

class FearPlayerHandler {
    fun handlePlayerFear(player: ServerPlayerEntity) {
        val fearPlayerData = FearDataManager.fearData.playersFearData.getOrDefault(player.displayName.string, FearPlayerData())
        handlePlayerFearLevel(player, fearPlayerData)

        val fearPercentage = getPlayerFearPercentage(fearPlayerData)
        handlePlayerFearForce(player, fearPercentage)

        if (fearPercentage == 100 && !player.isDead) {
            player.addStatusEffect(StatusEffectInstance(StatusEffects.BLINDNESS, 120))
            player.playSound(SoundEvents.ENTITY_WITCH_AMBIENT, SoundCategory.HOSTILE, 1.0f, 1.0f)
            fearPlayerData.baseFear += fearPlayerData.fearBuild * 5
            player.kill()
        }

        FearDataManager.fearData.playersFearData[player.displayName.string] = fearPlayerData
        //player.sendMessage(Text.literal("${fearPlayerData}"))
    }

    private fun getPlayerFearPercentage(playerData: FearPlayerData): Int {
        return ((playerData.fearLevel.toFloat()/playerData.maxFear.toFloat()) * 100).toInt()
    }

    private fun handlePlayerFearForce(player: ServerPlayerEntity, percentage: Int) {
        ModForces.forcePlayer(player, percentage)
    }

    private fun handlePlayerFearLevel(player: ServerPlayerEntity, playerData: FearPlayerData) {
        val hasSuppression = player.hasStatusEffect(ModEffects.FEAR_SUPPRESSION) || player.hasStatusEffect(ModEffects.FEAR_CURE)

        var newFearLevel = playerData.fearLevel
        if (player.isInSafe()) {
            newFearLevel = maxOf(playerData.fearLevel - playerData.fearBuild, playerData.baseFear)
        } else{
            if (!hasSuppression) {
                newFearLevel = minOf(playerData.fearLevel + playerData.fearDecay, playerData.maxFear)
            }
        }

        playerData.fearLevel = newFearLevel
    }

    fun ServerPlayerEntity.isInSafe(): Boolean {
        val isOverworld = world.registryKey.value == Identifier("minecraft", "overworld")
        val worldSpawn = world.spawnPos
        val playerPos = blockPos

        return isOverworld && playerPos.isWithinSafeRadius(worldSpawn, FearDataManager.fearData.safeRadius)
    }

    private fun BlockPos.isWithinSafeRadius(center: BlockPos, radius: Int): Boolean {
        return abs(x - center.x) <= radius && abs(z - center.z) <= radius
    }


}