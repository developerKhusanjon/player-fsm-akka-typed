package com.typed.player

import com.typed.player.player_behaviors.protocols.PlayerCommands.PlayerCommand
import akka.actor.typed.ActorRef
import com.typed.player.player_behaviors.protocols.PlayerReplies
import com.typed.player.player_interface.protocol.PlayerInterfaceCommands.Request

package object player_interface {

    private[player_interface] type PlayerCommandConstructor[C <: PlayerCommand] =
      ActorRef[PlayerReplies.Reply] => C

    private[player_interface] type Translator[C <: PlayerCommand] =
      PartialFunction[Request, PlayerCommandConstructor[C]]
}
