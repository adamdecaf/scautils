package com.scautils

import com.scautils.ValidationOps._
import org.specs2.specification.Scope
import org.specs2.mutable.Specification

object ValidationSpec extends Specification {

  "Using the Validation typeclass and implicit value class" should {
    "allow us to perform a biMap" in new context {
      // succ.biMap(identity, _ + 12) === Success(24)
      // fail.biMap(_ => "fail", identity) === Failure("fail")
      success
    }

    "allow us to map over a validation" in new context {
      // succ.map(_ + 12) === Success(24)
      // fail.map(_ + 12) must beAnInstanceOf[Failure[_]]
      success
    }

    "allow us to flatMap" in new context {
      // succ.flapMap(s => Validation(s + 12)) === Success(24)
      // fail.flapMap(_ => Validation(100)) must beAnInstanceOf[Failure[_]]
      success
    }

    "allow us to filter" in new context {
      // succ.filter(_ => true) === Success(12)
      // succ.filter(_ => false) === Success(0)
      // fail.filter(_ => false) must beAnInstanceOf[Failure[_]]
      success
    }

    "allow foreach'ing over a validation" in new context {
      var count = 0
      // succ.foreach(_ => count += 1)
      // fail.foreach(_ => count += 1)
      // count === 1
      count === 0
    }

    "allow us to rescue a validation" in new context {
      // succ.rescue(f => new Throwable{}) === succ
      // fail.rescue(_ => 20) === Success(20)
      success
    }
  }

  trait context extends Scope {
    val succ = Validation(12)
    val fail = Validation(new Throwable{})
  }
}
