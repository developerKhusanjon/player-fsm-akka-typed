import PlayerCommands._
import akka.actor.typed.ActorRef
import com.typed.player.models.Player

object PlayerReplies {

  sealed trait Reply {
    def state: Player
  }

  sealed trait SkippedReply extends Reply
  case class SkippedFromFirst(state: Player, replyTo: ActorRef[MiddleTrackCommand]) extends SkippedReply
  case class Skipped(state: Player) extends SkippedReply
  case class SkippedToLastTrack(state: Player, replyTo: ActorRef[LastTrackCommand]) extends SkippedReply

  sealed trait SkippedBackReply extends Reply
  case class SkippedBackFromLastTrack(state: Player, replyTo: ActorRef[MiddleTrackCommand]) extends SkippedBackReply
  case class SKippedBack(state: Player) extends SkippedBackReply
  case class SkippedBackFirst(state: Player, replyTo: ActorRef[FirstTrackCommand]) extends SkippedBackReply

  case class FirstTrackEnqueued(state: Player, replyTo: ActorRef[OnlyTrackCommand]) extends Reply
  case class SecondTrackEnqueued(state: Player, replyTo: ActorRef[FirstTrackCommand]) extends Reply
  sealed trait TrackEnqueuedReply extends Reply
  case class TrackEnqueuedAfterLast(state: Player, replyTo: ActorRef[MiddleTrackCommand]) extends TrackEnqueuedReply
  case class TrackEnqueued(state: Player) extends TrackEnqueuedReply

  case class Stopped(state: Player, replyTo: ActorRef[EmptyCommand]) extends Reply
}
