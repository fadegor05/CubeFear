package com.fadegor05.cubefear.fear

data class FearPlayerData(
    var baseFear: Int = 0,
    var maxFear: Int = 1 * 60 * 20 * 100,
    var fearLevel: Int = baseFear,
    var fearDecay: Int = 100,
    var fearBuild: Int = 100
)