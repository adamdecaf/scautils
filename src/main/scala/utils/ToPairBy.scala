package com.scautils

object ToPairBy {
  implicit final class ToPairByWrapper[A](val a: A) extends AnyVal {
    def toPairBy[B](f: A => B): Pair[A, B] = (a, f(a))
  }
}
