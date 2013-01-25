package com.scautils
import org.specs2.mutable.Specification

object InverseSpec extends Specification {
  import com.scautils.Inverse._
  import com.scautils.Inverses._

  "Using the Inverse" should {
    "give us the proper values back" in {
      minverse[Unit].inverse  === ()
      minverse(true).inverse  === false
      minverse(false).inverse === true
      minverse(12D).inverse   === -12D
      minverse(0D).inverse    === 0D
      minverse(100).inverse   === -100
      minverse(0).inverse     === 0
      minverse(50L).inverse   === -50L
      minverse(0L).inverse    === 0L
      minverse(62F).inverse   === -62F
      minverse(0F).inverse    === 0F
    }

    "and work for collection types" in {
      minverse(List(12, 51)).inverse            === List(-12, -51)
      minverse(Some(12)).inverse                === Some(-12)
      minverse(None).inverse                    === None
      minverse(Map(1 -> -2L, -3 -> 4L)).inverse === Map(-1 -> 2L, 3 -> -4L)
    }
  }
}
