package com.fadegor05.cubefear.forces

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.sound.SoundEvents

abstract class EffectForce: BaseForce {
    open val effects: List<StatusEffect> = listOf()

    override fun forcePlayer(player: ServerPlayerEntity) {
        val randomEffect = effects.random()
        player.playSound(SoundEvents.ENTITY_ENDER_DRAGON_FLAP, 1.0f, 1.0f)
        player.addStatusEffect(StatusEffectInstance(randomEffect, 10 * 20))
    }
}