package com.scautils

object unless {

  def apply[T](cond: => Boolean)(code: => T) =
    if (cond) code

}
