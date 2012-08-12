package com.scautils

object unless {

  // Change this so we can have U => Boolean for the cond.
  // Basically, support chaining.
  def apply[T](cond: => Boolean)(code: => T) =
    if (cond) code

}
