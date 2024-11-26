package com.fadegor05.cubefear.forces

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import kotlin.random.Random

object ModForces {
    private val MONSTER_FORCE = MonsterForce()
    private val ADVANCED_MONSTER_FORCE = AdvancedMonsterForce()
    private val BAD_EFFECT_FORCE = BadEffectForce()
    private val JUMPSCARE_FORCE = JumpscareForce()

    fun performWithChance(chance: Double): Boolean {
        return Random.nextDouble(0.0, 100.0) < chance
    }

    fun forcePlayer(player: ServerPlayerEntity, percentage: Int) {
        if (percentage < 50) return

        if (!performWithChance(percentage.toDouble()/100)) return

        val forces: MutableList<BaseForce> = mutableListOf()

        forces.add(MONSTER_FORCE)
        if (percentage >= 70) forces.add(ADVANCED_MONSTER_FORCE)
        if (percentage >= 80) forces.add(BAD_EFFECT_FORCE)
        if (percentage >= 90) forces.add(JUMPSCARE_FORCE)

        if (forces.size >= 1) {
            val randomForce = forces.random()
            randomForce.forcePlayer(player)
        }
    }
}