package com.scautils
import scala.annotation.implicitNotFound

// The idea is you can chain any number of Chain[A]'s onto each other
// and have the results zip through...
// Notes: Create a (Chain[A] => (f: A => _) => Chain[A])* version

object Chain {
  def apply[T](init: T) = new Chain(init)
}

class Chain[T] private(private val value: T) {
  def get: T = value

  def map[B](f: T => B): Chain[B] = new Chain(f(value))
  def flatMap[B](f: T => Chain[B]): Chain[B] = f(value)

  def fold[TT >: T](z: TT)(f: (TT, TT) => TT): TT = f(z, value)
  def foldLeft[B](z: B)(f: (B, T) => B): B = f(z, value)

  def filter(f: T => Boolean): Chain[Option[T]] = f(value) match {
    case true  => new Chain(Some(value))
    case false => new Chain(Option.empty[T])
  }

  @implicitNotFound(msg = "Cannot find Chain.toOption type class for ${T}")
  def toOption()(implicit f: T => Option[T]): Option[T] = Optional(value)(f)
}
