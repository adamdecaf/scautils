package com.scautils.math

object Factorial {
  private var history = Map[Int, Int]()

  def fact(n: Int): Int = {
    n match {
      case 1 | 0 => n
      case _ =>
        println(history.contains(n))
        println(history)
        if (history.contains(n)) {
          println("Found " + n)
          n
        } else {
          println("Not Found")
          var result = (n -> (fact(n-1) + fact(n-2)))
          history += result
          println("Added! " + result)
          history.get(n).get
        }
    }
  }
}
