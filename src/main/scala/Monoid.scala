package com.scautils
import scala.language.higherKinds

trait Monoid[M] {
  def zero: M
  def append(x: M, y: M): M
}

object Monoid {
  def apply[M: Monoid]: Monoid[M] = implicitly[Monoid[M]]

  def apply[M: Zero](f: (M, M) => M): Monoid[M] = new Monoid[M] {
    def zero: M = implicitly[Zero[M]].zero
    def append(x: M, y: M): M = f(x, y)
  }
}
