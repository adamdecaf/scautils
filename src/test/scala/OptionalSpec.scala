package com.scautils

import java.io.{File, FileInputStream, InputStream}
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

  "Work for extra values" should {
    "work for InputStream's" in {
      lazy val empty: InputStream = null
      lazy val full: InputStream  = new FileInputStream("src/test/scala/OptionalSpec.scala")
      Optional(empty) must beNone
      Optional(full) must beSome
    }

    "work for Files/paths" in {
      val empty: File = null
      val empty2: File = new File("/sdasda/sdasdsdsd/dsdads")
      val full: File = new File("src/test/scala/OptionalSpec.scala")
      Optional(empty) must beNone
      Optional(empty2) must beNone
      Optional(full) must beSome
    }
  }
}
