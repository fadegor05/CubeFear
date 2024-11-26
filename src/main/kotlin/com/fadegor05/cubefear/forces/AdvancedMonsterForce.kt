package com.fadegor05.cubefear.forces


import net.minecraft.sound.SoundEvents

class AdvancedMonsterForce: SoundForce() {
    override var sounds = listOf(
        SoundEvents.ENTITY_SHULKER_HURT,
        SoundEvents.ENTITY_SHULKER_AMBIENT,
        SoundEvents.ENTITY_WITHER_SHOOT,
        SoundEvents.ENTITY_WITHER_HURT,
        SoundEvents.ENTITY_ENDERMAN_SCREAM,
        SoundEvents.ENTITY_WITHER_AMBIENT,
    )
}