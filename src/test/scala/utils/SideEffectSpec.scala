package com.scautils

import com.scautils.SideEffect._
import org.specs2.mutable.Specification

object SideEffectSpec extends Specification {

  "Using the SideEffect" should {
    "modify outside values" in {
      var count = 0
      "Test".sideEffect(_ => count += 1, _ => count += 2) === "Test"
      count === 3
    }
  }

}
