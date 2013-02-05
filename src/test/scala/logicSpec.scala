package com.scautils

import com.scautils.logic._
import org.specs2.mutable.Specification

object LogicSpec extends Specification {

  "Using xor on booleans" should {
    "work over all values" in {
      (true xor true) === false
      (true xor false) === true
      (false xor true) === true
      (false xor false) === false
    }
  }

}
