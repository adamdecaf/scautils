package com.scautils

object SideEffect {

  implicit final class SideEffecting[T](val t: T) extends AnyVal {
    def sideEffect[N](fs: (T => N)*): T = locally {
      fs.foreach(f => f(t))
      t
    }
  }

}
