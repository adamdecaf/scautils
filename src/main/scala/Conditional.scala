package com.scautils

class Conditional[T](value: T) {
 private val hideMe: T = value

 def get(cond: Boolean): Option[T] = if (cond) Some(hideMe) else None

 def get(cond: T => Boolean): Option[T] = get(cond(hideMe))

}

object Conditional {
 def apply[T](item: T) = new Conditional(item)
}
