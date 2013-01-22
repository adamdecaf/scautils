package com.scautils
import scala.math.Ordering

object Compare extends Enumeration {
  val Less    = Value
  val Equal   = Value
  val Greater = Value
}

trait Compare[A] extends Ordering[A] {
  def order(x: A, y: A): Compare.Value

  def compare(x: A, y: A): Int = order(x, y) match {
    case Compare.Less => -1
    case Compare.Equal => 0
    case Compare.Greater => 1
  }
}
