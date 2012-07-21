package com.scautils

import org.specs2.mutable.Specification

object ConditionalSpec extends Specification {

  "Setting up a conditional object" should {
    "work to store a value and give back and Option[T] depending on the function you pass it" in {
      val obj = Conditional(100)
      obj.get(_ > 200) must beEqualTo(None)
      obj.get(_ > 50) must beEqualTo(Some(100))
    }
  }

}
