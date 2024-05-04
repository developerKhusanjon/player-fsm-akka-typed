import PlayerCommands.EmptyCommand
import akka.actor.typed.ActorSystem
import akka.util.Timeout

import scala.concurrent.duration.DurationInt

object Main extends App {

  implicit val timeout: Timeout = 3.seconds
  implicit val system: ActorSystem[EmptyCommand] = ActorSystem(Player)
}
