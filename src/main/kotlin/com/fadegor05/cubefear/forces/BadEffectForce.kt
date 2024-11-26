package com.fadegor05.cubefear.forces

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffects

class BadEffectForce: EffectForce() {
    override val effects: List<StatusEffect> = listOf(
        StatusEffects.NAUSEA,
        StatusEffects.BLINDNESS,
        StatusEffects.POISON,
        StatusEffects.WEAKNESS,
    )
}