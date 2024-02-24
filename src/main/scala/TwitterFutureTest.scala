import com.twitter.conversions.DurationOps.richDurationFromInt
import com.twitter.util.{Await, FuturePool}

object TwitterFutureTest extends App {
  val future = FuturePool.unboundedPool {
    throw new LinkageError("Fatal error thrown.")
  }

  future.onFailure {
    case e: Exception => println(s"Future is completed exceptionally: $e")
  }

  try {
    Await.result(future, 1.second)
  } catch {
    case e: Exception => println(s"We can handle a fatal exception: $e")
  }
}
