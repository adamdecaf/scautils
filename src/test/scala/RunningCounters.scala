package org.scautils.math

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

object RunningCountersHelpers { 
  
  "RunningMin" should {
    "keep track of the lowest value." in {
      RunningMin.start(0)
      RunningMin.acc(10)
      RunningMin.acc(-1)
      RunningMin.get === -1
    }
  }

}
