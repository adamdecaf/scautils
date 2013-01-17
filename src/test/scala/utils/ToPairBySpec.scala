package com.scautils

import com.scautils.ToPairBy._
import org.specs2.mutable.Specification

object ToPairBySpec extends Specification {

  "Using the ToPairBy" should {
    "modify outside values" in {
      "Test".toPairBy(_.length) === ("Test", 4)
    }
  }

}
