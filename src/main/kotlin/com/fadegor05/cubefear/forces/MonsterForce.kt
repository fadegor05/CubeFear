package com.fadegor05.cubefear.forces

import net.minecraft.sound.SoundEvents

class MonsterForce: SoundForce() {
    override var sounds = listOf(
        SoundEvents.ENTITY_ZOMBIE_STEP,
        SoundEvents.ENTITY_ZOMBIE_AMBIENT,
        SoundEvents.ENTITY_ENDERMAN_AMBIENT,
        SoundEvents.ENTITY_ZOMBIE_HURT,
        SoundEvents.ENTITY_SKELETON_STEP,
        SoundEvents.ENTITY_SKELETON_SHOOT,
        SoundEvents.ENTITY_SKELETON_AMBIENT,
        SoundEvents.ENTITY_CREEPER_HURT,
        SoundEvents.ENTITY_SPIDER_AMBIENT
    )
}