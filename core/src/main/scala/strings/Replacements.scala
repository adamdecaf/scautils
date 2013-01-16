package com.scautils.strings

case class ReplacementCanditate(token: String, update: String)

object + {
  def unapply(s: String) = Some(s.take(1) -> s.drop(1))
}

object Replacements {
  final val tokenFlag = "%"

  def apply(initialString: String): Replacements = {
    new Replacements(initialString)
  }
}

class Replacements private(private val initialString: String) {

  def apply(canidates: ReplacementCanditate*): String = {
    val allReplacements = canidates.toList

    def cycleThroughString(str: String): String = str match {
      case head + tail if (head == Replacements.tokenFlag) =>
        val token = tail.takeWhile(_ != " ")
        val replacements = allReplacements.filter(_.token == token)

        val newLeft = replacements.foldLeft("")((newValue, currValue) => currValue.update)
        val newRight = tail.drop(token.length)
        newLeft + cycleThroughString(newRight)

      case head + tail => head + cycleThroughString(tail)
    }

    cycleThroughString(initialString)
  }
}
