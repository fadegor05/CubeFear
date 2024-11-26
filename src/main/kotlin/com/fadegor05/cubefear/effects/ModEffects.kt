package com.fadegor05.cubefear.effects

import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModEffects {
    val FEAR_SUPPRESSION = FearSuppressionEffect()

    fun registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, Identifier("cubefear", "fear_suppression"), FEAR_SUPPRESSION)
    }
}