package com.scautils

object PairOps {

  // Extend this to all Tuple1-22's?

  implicit final class PairOps[+A, +B](val pair: Pair[A, B]) extends AnyVal {
    def car: A = pair._1
    def cdr: B = pair._2

    // Expand the size of the tuple here..
    // def cons
  }

}
