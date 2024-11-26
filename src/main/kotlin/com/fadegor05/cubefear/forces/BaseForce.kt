package com.fadegor05.cubefear.forces

import net.minecraft.server.network.ServerPlayerEntity

interface BaseForce {
    fun forcePlayer(player: ServerPlayerEntity)
}