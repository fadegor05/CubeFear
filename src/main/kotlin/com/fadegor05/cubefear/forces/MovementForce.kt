package com.fadegor05.cubefear.forces

import net.minecraft.entity.MovementType
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.math.Vec3d

class MovementForce: BaseForce {
    override fun forcePlayer(player: ServerPlayerEntity) {
        player.applyMovementInput(Vec3d.fromPolar(1.0f, 1.0f), 1.0f)
    }
}