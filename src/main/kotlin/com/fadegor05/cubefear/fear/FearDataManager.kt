package com.fadegor05.cubefear.fear

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.fabricmc.loader.api.FabricLoader
import java.io.File
import java.nio.file.Path
import kotlin.io.path.exists

object FearDataManager {
    val fearDataPath: Path = FabricLoader.getInstance().configDir.resolve("cubefear.json")
    var fearData: FearData = loadFearData()

    fun saveFearData() {
        val json = Json.encodeToString(fearData)
        val file = File(fearDataPath.toString())
        file.createNewFile()
        file.writeText(json)
    }

    private fun loadFearData(): FearData {
        val file = File(fearDataPath.toString())
        return if (file.exists()) {
            Json.decodeFromString(file.readText())
        } else {
            FearData()
        }
    }

}