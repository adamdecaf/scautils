package com.scautils
import scala.language.higherKinds

abstract class Semigroup[M[_], A](protected val value: A) {
  def append(f: A => A)(o: A): A
}
