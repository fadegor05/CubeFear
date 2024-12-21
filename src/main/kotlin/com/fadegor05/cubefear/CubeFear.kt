package com.fadegor05.cubefear

import com.fadegor05.cubefear.effects.ModEffects
import com.fadegor05.cubefear.fear.FearCore
import com.fadegor05.cubefear.fear.FearDataManager
import com.fadegor05.cubefear.potions.ModPotions
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.nbt.NbtCompound
import net.minecraft.potion.Potions
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class CubeFear : ModInitializer {

    override fun onInitialize() {
        ModEffects.registerEffects()
        ModPotions.registerPotions()

        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.STRENGTH, Ingredient.ofItems(Items.GLOW_BERRIES), ModPotions.FEAR_SUPPRESSING_POTION)
        FabricBrewingRecipeRegistry.registerPotionRecipe(ModPotions.FEAR_SUPPRESSING_POTION, Ingredient.ofItems(Items.GOLDEN_APPLE), ModPotions.FEAR_CURE_POTION)
        FearCore()

        ServerLifecycleEvents.SERVER_STOPPED.register {
            FearDataManager.saveFearData()
        }
    }

}
