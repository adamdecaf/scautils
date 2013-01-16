package com.scautils
import scala.language.implicitConversions

object ForSome {

  implicit def forSomeOnIterable[A](i: Iterable[A]) = new {
    def some(f: A => Boolean): Boolean = {
      // def forsome[A](items: Iterable[A])(f: A => Boolean) = !items.forall(!f(_))
      !i.forall(!f(_))
    }
  }

}
