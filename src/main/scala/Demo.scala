import com.typesafe.scalalogging.LazyLogging

object Demo extends App with LazyLogging {

  println("Press Enter for a new logline or anystring + enter to abort:")

  lazy val fib: Stream[Int] = {
    def loop(h: Int, n: Int): Stream[Int] = {
      val in = io.StdIn.readLine()
      if (in.nonEmpty) {
        Nil.toStream
      } else {
        h #:: loop(n, h + n)
      }
    }
    loop(1, 1)
  }


  def doLog(msg:String) {
    logger.info(msg)
    //logger.warn(msg)
    //logger.error(msg, new IllegalStateException())
  }

  fib.map(_ + "_msg").foreach(doLog)


}
