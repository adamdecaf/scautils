package com.scautils
import scala.language.reflectiveCalls

object ForAll extends ForAll

trait ForAll {

  private[this] var status = false

  def apply[T, A <: { def forAll: T => Boolean }](items: A, cond: T) =
    items.forAll(cond)

  // def apply[A](items: Iterable[A], f: Function[A, Boolean]) =
  //   apply(items.toIterator, f)

  def apply[A](items: Iterator[A], f: Function1[A, Boolean]) = {
    while (items.hasNext) {
      AlwaysAct(items.next, f)((no: A) => status = true, (yes: A) => status = false)
    }
  }

}
