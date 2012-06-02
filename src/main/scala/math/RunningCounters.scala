package org.scautils.math

trait RunningCounterHelper {
  protected var successor = 0
  protected def valueHelper(next: Int)(f: Int => Boolean): Unit = {
    (if (f(next)) successor = next)
  }

  def start(start: Int): Unit = successor = start; ()
  def acc(next: Int): Unit
  def get: Int = successor
}

object RunningMin extends RunningCounterHelper {
  def acc(next: Int): Unit = valueHelper(next)(_ < successor)
}

object RunningMax extends RunningCounterHelper {
  def acc(next: Int): Unit = valueHelper(next)(_ > successor)
}
