package com.fadegor05.cubefear.forces

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvent

abstract class SoundForce: BaseForce {
    open var sounds: List<SoundEvent> = listOf()

    override fun forcePlayer(player: ServerPlayerEntity) {
        val randomSound = sounds.random()
        player.playSound(randomSound, SoundCategory.MASTER, 1.0f, 1.0f)
    }
}