package com.scautils

import org.specs2.mutable.Specification

object DefaultSpec extends Specification {

  "Using the default operator" should {
    "work when the cond is true" in {
      ??("good", "bad").get(_.length > 3) === "good"
      ??(-1, 1).get(_ < 0) === -1
    }

    "work when the cond is false" in {
      ??("good", "bad").get(_.length > 10) === "bad"
      ??(-1, 1).get(_ < -10) === 1
    }
  }

}
