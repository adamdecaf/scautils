package com.scautils
import scala.language.higherKinds

abstract class Monoid[M[_], A](override protected val value: A) extends Semigroup[M, A](value) {
  def identity(implicit mzero: Zero[A]) = mzero.zero
}
