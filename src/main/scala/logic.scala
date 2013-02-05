package com.scautils

object logic {
  implicit final class BooleanLogicWrapper(val b: Boolean) extends AnyVal {
    def xor(b2: Boolean): Boolean = (b != b2)
  }
}
