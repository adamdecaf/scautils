package org.scautils.strings

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

object MapReplaceSpec extends Specification {
  "Given a map and some starting string we " should {
    "be able to repalce everything we want on it." in new mapRepalceContext {
      MapReplace.replace(cookbook, replacee) === validResult
    }
  }
}

trait mapRepalceContext extends Scope {
  val cookbook = Map("a" -> "1", "b" -> "2", "3" -> "c")
  val replacee = "aabcc3"
  val validResult = "112ccc"
}
