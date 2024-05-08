package com.typed.player.player_behaviors

import akka.actor.typed.Behavior
import com.typed.player.player_behaviors.protocols.PlayerCommands.PlayerCommand

private trait PlayerBehavior[C <: PlayerCommand] {
    def receiveMessage(cmd: C): Behavior[PlayerCommand]
}
