package com.scautils

import org.specs2.specification.Scope
import org.specs2.mutable.Specification

object Animals extends Enumeration {
  val Bird  = Value
  val Dog   = Value
  val Deer = Value
}

object CompareSpec extends Specification {

  "Using the compare on some set of objects" should {
    "should give us the correct min" in new context {
      List(Animals.Deer, Animals.Dog, Animals.Bird).min === Animals.Bird
    }

    "give us the correct max" in new context {
      List(Animals.Deer, Animals.Dog, Animals.Bird).max === Animals.Deer
    }

    "give us a middle" in new context {
      List(Animals.Deer, Animals.Dog, Animals.Bird, Animals.Deer, Animals.Bird).sortWith(_<_) === List(Animals.Bird, Animals.Bird, Animals.Dog, Animals.Deer, Animals.Deer)
    }
  }


  trait context extends Scope {
    implicit val AnimalOrdering = new Compare[Animals.Value] {
      def order(x: Animals.Value, y: Animals.Value) = (x, y) match {
        case (Animals.Bird, Animals.Bird) => Compare.Equal
        case (Animals.Bird, _) => Compare.Less

        case (Animals.Dog, a: Animals.Value) => a match {
          case Animals.Bird => Compare.Greater
          case Animals.Dog => Compare.Equal
          case Animals.Deer => Compare.Less
        }

        case (Animals.Deer, Animals.Deer) => Compare.Equal
        case (Animals.Deer, _) => Compare.Greater
      }
    }
  }
}
