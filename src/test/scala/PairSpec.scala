package com.scautils

import org.specs2.specification.Scope
import org.specs2.mutable.Specification

object PairSpec extends Specification {
  import PairOps._

  "Using the PairOps" should {
    "give us the car and cdr of a pair" in new context {
      pair.car === "a"
      pair.cdr === 12
    }
  }

  trait context extends Scope {
    val pair = Tuple2("a", 12)
  }
}
