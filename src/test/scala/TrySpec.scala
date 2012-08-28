package com.scautils

import org.specs2.mutable.Specification

object TrySpec extends Specification {

  "Using the Try object" should {
    "work as intended to setup operations" in {
      val fail = Try("str".asInstanceOf[Char])
      val good = Try(12)

      fail.isInstanceOf[Failure[_]] must beTrue
      good === Success(12)
    }

    "work for mapping and folding over results" in {
      val fail = Try("str".asInstanceOf[Char])
      val good = Try(12)

      good.map(_.toLong) === Success(12L)
      good.fold(println(_), _ * 2) === 24
    }
  }

}
