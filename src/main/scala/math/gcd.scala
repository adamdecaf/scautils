package com.scautils

object Math {

  def gcd(m: Int, n: Int): Int = {
    val start = (1 to scala.math.min(m,n)).reverseIterator
    while (start.hasNext) {
      val x = start.next
      if (m % x == 0 && n % x == 0) return x
    }
    return 1
  }

}
