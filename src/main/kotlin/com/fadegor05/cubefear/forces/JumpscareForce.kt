package com.fadegor05.cubefear.forces

import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.particle.ParticleType
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents

class JumpscareForce: BaseForce {
    override fun forcePlayer(player: ServerPlayerEntity) {
        player.world.addParticle(ParticleTypes.ELDER_GUARDIAN, player.x, player.y+2, player.z, 0.0, 0.0, 0.0)
        player.playSound(SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.HOSTILE, 1.0f, 1.0f)
        player.addStatusEffect(StatusEffectInstance(StatusEffects.BLINDNESS, 10 * 20))
    }
}