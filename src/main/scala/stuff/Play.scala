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

  //P02 (*) Find the last but one element of a list.

  // tip:
  // list.init.last -> init get all the elements except the last
  def findPenultimateElement[T](list: List[T]): T =
    if (list.size < 2) throw new NoSuchElementException
    else
      list(list.length - 2)

  def findPenultimateElementPatternMatching[T](list: List[T]): T = list match {
    case e1 :: e2 :: Nil => e1
    case e :: tail => findPenultimateElementPatternMatching(tail)
    case _ => throw new NoSuchElementException
  }

  println("penultimate element:" + findPenultimateElement(list))
  println("penultimate element (pm):" + findPenultimateElementPatternMatching(list))

  //P03 (*) Find the Kth element of a list.

  def findKthElement[T](list: List[T], k: Int): T = {
    def isInputValid() : Boolean = k > -1 && k < list.size
    if(isInputValid()) list(k) else
      throw new NoSuchElementException
  }  

  def findKthElementPatternMatching[T](list: List[T], k: Int): T = (list, k) match {
    case (head :: tail, 0) => head
    case (head :: tail, _) => findKthElementPatternMatching(tail, k - 1)
    case (Nil, _ ) => throw new NoSuchElementException
  }

  println("Kth element:" + findKthElement(list, 0))
  println("Kth element:" + findKthElement(list, 3))
  println("Kth element (pm):" + findKthElementPatternMatching(list, 0))
  println("Kth element (pm):" + findKthElementPatternMatching(list, 3))

}
