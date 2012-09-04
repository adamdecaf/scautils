package com.scautils

import org.specs2.mutable.Specification

object OptionalSpec extends Specification {
  import Optionals._

  "The Optional object" should {
    "be able to work on booleans" in {
      Optional(true) === Some(true)
      Optional(false) === None
    }

    "be able to work on numerics" in {
      Optional(0)     === None
      Optional(0L)    === None
      Optional(0.0)   === None
      Optional(1)     === Some(1)
      Optional(1L)    === Some(1L)
      Optional(1.1)   === Some(1.1)
      Optional(BigInt(0)) === None
      Optional(1F)    === Some(1F)
      Optional(1D)    === Some(1D)
    }

    "be able to work on lots of standard library structures" in {
      Optional(Seq()) === None
      Optional(None) === None
      Optional(Seq(Seq())) === Some(Seq(Seq()))
    }

    "be able to handle strings" in {
      Optional("") === None
      Optional(" oooo ") === Some(" oooo ")
    }

    "be able to take some misc values" in {
      Optional(()) === None
      Optional() === None
    }
  }


}
