package stuff

import org.scalatest._

object Play extends App {
  // got this from the internet:
  //http://aperiodic.net/phil/scala/s-99/

  //P01 (*) Find the last element of a list.
  def findLastElement[T](list: List[T]): T = list.last

  def findLastElementPatternMatching[T](list: List[T]): T = list match {
    case e :: Nil => e
    case e :: tail => findLastElementPatternMatching(tail)
    case _ => throw new NoSuchElementException
  }

  val list = List(1, 2, 3, 4);
  println("last element:" + findLastElement(list))
  println("last element (pm):" + findLastElementPatternMatching(list))

}