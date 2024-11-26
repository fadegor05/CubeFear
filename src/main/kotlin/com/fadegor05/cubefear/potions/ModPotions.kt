package com.fadegor05.cubefear.potions

import com.fadegor05.cubefear.effects.ModEffects
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.potion.Potion
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModPotions {
    val FEAR_SUPPRESSING_POTION = Potion("fear_supressing", StatusEffectInstance(ModEffects.FEAR_SUPPRESSION, 60 * 20))

    fun registerPotions() {
        Registry.register(Registries.POTION, Identifier("cubefear", "fear_suppressing"), FEAR_SUPPRESSING_POTION)
    }
}