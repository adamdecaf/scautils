package org.scautils.math

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

object RunningCountersHelpers extends Specification {

  "RunningMin" should {
    "keep track of the lowest value." in {
      RunningMin.start(0)
      RunningMin.acc(10)
      RunningMin.acc(-1)
      RunningMin.get === -1
    }
  }

  "RunningMax" should {
    "keep track of the highest value" in {
      RunningMax.start(0)
      RunningMax.acc(-1)
      RunningMax.acc(10)
      RunningMax.get === 10
    }
  }

}
