package com.scautils

object functions extends functions

trait functions {

  // Usage: List(1,2,3,4).foldLeft(Zero[Int].zero)(plus) == 10
  def plus[@specialized(Double, Int, Long) T](a: T, b: T)(implicit m: Monoid[T]): T = m.append(a, b)

}
