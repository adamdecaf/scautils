package com.scautils.math

trait RunningCounterHelper {
  protected var successor = 0
  protected def valueHelper(next: Int)(f: Int => Boolean): Unit =
    if (f(next)) successor = next

  def start(start: Int): Unit = successor = start
  def acc(next: Int): Unit
  def get: Int = successor
}

object RunningMin extends RunningCounterHelper {
  def acc(next: Int): Unit = valueHelper(next)(_ < successor)
}

object RunningMax extends RunningCounterHelper {
  def acc(next: Int): Unit = valueHelper(next)(_ > successor)
}

/*
class RunningCounter[T <: Numeric[_]](start: T, cond: (T, T) => Boolean) {
  private var successor: T = _

  def acc(next: T) = if(cond(successor, next)) successor = next
  def get = successor
}

object RunningCounter {
  def apply[T <: Numeric[_]](start: T) =
    new RunningCounter[T](start, cond)
}
*/
