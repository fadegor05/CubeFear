package com.fadegor05.cubefear.fear

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FearPlayerData(
    @SerialName("base_fear") var baseFear: Int = 0,
    @SerialName("max_fear") var maxFear: Int = 1 * 20 * 100 * 60,
    @SerialName("fear_level") var fearLevel: Int = baseFear,
    @SerialName("fear_decay") var fearDecay: Int = 100,
    @SerialName("fear_build") var fearBuild: Int = 100
)