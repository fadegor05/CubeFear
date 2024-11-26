package com.fadegor05.cubefear.fear

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents

class FearCore {
    init {
        val fearPlayerHandler = FearPlayerHandler()
        ServerTickEvents.START_SERVER_TICK.register { server ->
            server.playerManager.playerList.forEach { player ->
                fearPlayerHandler.handlePlayerFear(player)
            }
        }
    }
}