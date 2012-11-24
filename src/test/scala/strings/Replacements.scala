package com.scautils.strings

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

object ReplacementsSpec extends Specification {

  "Using the Replacements to work over a string" should {
    "replace values based on the tokens" in new context {
      Replacements(tokenedString)(somethingToDog, otherToBurrito) === correctString
    }
  }

  trait context extends Scope {
    val tokenedString = "   testing    %something %other "
    val correctString = "   testing    dogs burrito "

    val somethingToDog = ReplacementCanditate("%something", "dog")
    val otherToBurrito = ReplacementCanditate("%other", "burrito")
  }
}
