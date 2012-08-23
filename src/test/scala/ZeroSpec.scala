package com.scautils

import org.specs2.mutable.Specification

object ZeroSpec extends Specification {
  import scala.collection.immutable.{Queue, Stack}

  "Using Zero on a bunch of different collections" should {
    "work for Zero[_]" in {
      val byte: Byte = 1
      Zero(byte).zero   == byte must beTrue
      Zero(false).zero      === true
      Zero("a".head).zero   === "a".head
      Zero(1.toDouble).zero === 1.toDouble
      Zero(1.toFloat).zero  === 1.toFloat
      Zero(1).zero          === 1
      Zero(1L).zero         === 1L
      //Zero("some").zero     === ""
      Zero(()).zero             === ()
    }

    "work for Zero[_[_]]" in {
      Zero(Stack(1)).zero   === Stack[Int]()
      Zero(Stream(1)).zero  === Stream[Int]()
      Zero(Vector(1)).zero  === Vector[Int]()
      Zero(Array(1)).zero   === Array[Int]()
      Zero(List(1)).zero    === List[Int]()
      Zero(Some(1)).zero    ==  Option.empty[Int] must beTrue
      Zero(Queue(1)).zero   === Queue[Int]()
      Zero(Seq(1)).zero     === Seq[Int]()
      Zero(Set(1)).zero     === Set[Int]()
    }

    "work for Zero[_[_,_]]" in pending
    // {
    //   Zero[Int, String, Map](Map(1 -> "")).zero === Map[Int, String]()
    // }.pendingUntilFixed
  }

}
