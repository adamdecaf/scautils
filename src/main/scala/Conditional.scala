package com.scautils

class Conditional[T](value: T) {
 private val hideMe: T = value

 def get(cond: T => Boolean): Option[T] =
   if (cond(hideMe)) Some(hideMe) else None
}

object Conditional {
 def apply[T](item: T) = new Conditional(item)
}
