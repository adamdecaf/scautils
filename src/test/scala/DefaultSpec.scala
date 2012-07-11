package com.scautils

import org.specs2.mutable.Specification

object DefaultSpec extends Specification {

  "Using the default operator" should {
    "work when the cond is true" in {
      ??(true)("good", "bad") === "good"
      ??(true)(-1, 1) === -1
    }

    "work when the cond is false" in {
      ??(false)("good", "bad") === "bad"
      ??(false)(-1, 1) === 1
    }
  }

}
