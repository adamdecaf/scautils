package com.scautils

object Semigroup {
  def apply[T](implicit s: Semigroup[T]): Semigroup[T] = s
}

trait Semigroup[T] {

  // Binary operation that's associative and closed over T.
  // This should only evaluate b if a holds.
  def operation(a: T, b: => T): T

}
