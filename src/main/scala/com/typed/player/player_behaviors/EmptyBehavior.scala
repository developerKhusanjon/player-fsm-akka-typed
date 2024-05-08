package com.typed.player.player_behaviors

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.ActorContext
import com.typed.player.models.Player
import com.typed.player.player_behaviors.protocols.PlayerCommands._
import com.typed.player.player_behaviors.protocols.PlayerReplies.ShuffleToggled

private case class EmptyBehavior(state: Player, ctx: ActorContext[PlayerCommand]) extends PlayerBehavior[EmptyCommand] {

  override def receiveMessage(cmd: EmptyCommand): Behavior[PlayerCommand] = cmd match {
    case ToggleShuffle(replyTo) =>
      val newState = state.toggleShuffle()
      replyTo ! ShuffleToggled(newState)
      PlayerBehaviorFactory.empty(newState)
    case EnqueueFirstTrack(track, replyTo) =>
      val newState =  state.enqueue(track)
      PlayerBehaviorFactory.onlyTrack(newState)
  }
}
