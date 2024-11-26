package com.fadegor05.cubefear

import com.fadegor05.cubefear.effects.ModEffects
import com.fadegor05.cubefear.fear.FearCore
import com.fadegor05.cubefear.potions.ModPotions
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry
import net.minecraft.item.Items
import net.minecraft.potion.Potions
import net.minecraft.recipe.Ingredient

class CubeFear : ModInitializer {

    override fun onInitialize() {
        ModEffects.registerEffects()
        ModPotions.registerPotions()

        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.ofItems(Items.COPPER_INGOT), ModPotions.FEAR_SUPPRESSING_POTION)
        FearCore()

    }

}
