package com.typed.player.player_interface.protocol

import PlayerInterfaceReplies.Reply
import akka.actor.typed.ActorRef
import com.typed.player.models.Track
import com.typed.player.player_behaviors.protocols.PlayerReplies

object PlayerInterfaceCommands {

  sealed trait Command {
    def replyTo: ActorRef[Reply]
  }

  sealed trait Request extends Command
  case class TogglePlay(replyTo: ActorRef[Reply]) extends Request
  case class ToggleShuffle(replyTo: ActorRef[Reply]) extends Request
  case class Skip(replyTo: ActorRef[Reply]) extends Request
  case class SkipBack(replyTo: ActorRef[Reply]) extends Request
  case class EnqueueTrack(track: Track, replyTo: ActorRef[Reply]) extends Request
  case class Stop(replyTo: ActorRef[Reply]) extends Request

  private[player_interface] case class PlayerReply(
                                                    reply: PlayerReplies.Reply,
                                                    replyTo: ActorRef[Reply]
                                                  ) extends Command
}
