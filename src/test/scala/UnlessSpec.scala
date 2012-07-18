package com.scautils

import org.specs2.mutable.Specification

object UnlessSpec extends Specification {

  "The unless object" should {
    "work to execute some code only when the cond is true" in {
      val ret = unless(1 == 1) { 100 + 123 }
      ret === 223
    }

    "and not execute when the cond is false" in {
      val ret = unless(1 == 2) { 100 + 123 }
      ret === ()
    }
  }
}
