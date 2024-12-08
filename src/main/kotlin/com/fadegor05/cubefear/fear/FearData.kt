package com.fadegor05.cubefear.fear

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FearData(
    @SerialName("players_fear_data") var playersFearData: MutableMap<String, FearPlayerData> = mutableMapOf(),
    @SerialName("safe_radius") var safeRadius: Int = 200
)