package com.scautils
import scala.language.higherKinds

trait Semigroup[S] {
  def append(x: S, y: S): S
}

object Semigroup {
  def apply[S: Semigroup]: Semigroup[S] = implicitly[Semigroup[S]]

  def apply[S: Zero](f: (S, S) => S): Semigroup[S] = new Semigroup[S] {
    def append(x: S, y: S): S = f(x, y)
  }
}
