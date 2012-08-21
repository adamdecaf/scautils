package com.scautils

object ForSome {

  implicit def forSomeOnIterable[A](i: Iterable[A]) = new {
    def some(f: A => Boolean): Boolean = {
      !i.forall(!f(_))
    }
  }

}
