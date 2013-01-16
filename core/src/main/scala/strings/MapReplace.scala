package org.scautils.strings
import scala.language.implicitConversions

object MapReplace {
  private implicit def chrToString(c: Char): String = c.toString

  def replace(cookbook: Map[String, String], replacee: String): String = {
    replacee.map{ chr => cookbook.get(chr).getOrElse(chr) }.mkString
  }
}
