package com.scautils

trait Optional {
  def apply[T](in: T): Option[T]
}

object Optional {

  def apply[T <: { def isEmpty: Boolean }](obj: T) = {
    if (obj.isEmpty) None
    else Some(obj)
  }

  def apply(u: Unit) = None

  def apply(b: Boolean) = {
    if (!b) None
    else Some(b)
  }

  // A tolerance would probably be better, but
  // I can see a use for not including one.
  def apply(i: Long) = {
    if (i == 0) None
    else Some(i)
  }

  def apply(d: Double) = {
    if (d == 0) None
    else Some(d)
  }

  def apply(s: String) = {
    if (s.isEmpty) None
    else Some(s)
  }

  // Assumes a right-based Either, sorry...
  def apply[L, R](e: Either[L,R]) = {
    if (e.isLeft) None
    else Some(e.right.get)
  }

}
