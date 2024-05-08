package com.typed.player.player_behaviors

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.ActorContext
import com.typed.player.models.Player
import com.typed.player.player_behaviors.protocols.PlayerCommands._
import com.typed.player.player_behaviors.protocols.PlayerReplies.PlayToggled

private case class FirstTrackBehavior(state: Player, ctx: ActorContext[PlayerCommand]) extends PlayerBehavior[FirstTrackCommand] {

  override def receiveMessage(cmd: FirstTrackCommand): Behavior[PlayerCommand] = cmd match {
    case TogglePlay(replyTo) =>
      val newState = state.togglePlay()
      replyTo ! PlayToggled(newState)
      PlayerBehaviorFactory.firstTrack(newState)
  }
}
