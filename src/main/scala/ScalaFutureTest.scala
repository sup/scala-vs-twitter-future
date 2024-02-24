import scala.concurrent.{Await, ExecutionContext, Future, TimeoutException}
import ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt

object ScalaFutureTest extends App {
  val future = Future {
    throw new LinkageError("Fatal error thrown.")
  }

  future.onComplete {
    case scala.util.Failure(e) => println(s"Will not print $e")
    case scala.util.Success(v) => println(s"Will not print $v")
  }

  try {
    Await.result(future, 1.second)
  } catch {
    case e: Exception => println(s"But we actually see a timeout: $e")
  }
}
