package com.scautils

// object ForAll extends ForAll

// trait ForAll {

//   private[this] var status = false

//   def apply[T, A <: { def forAll: T => Boolean }](items: A, cond: T) =
//     items.forAll(cond)

//   // Call .forAll on a collection which has it implemented.
//   def apply[A](items: Iterable[_], f: Function[A, Boolean]) =
//     apply(items.toIterator, f)

//   // Normal version, where the cond is user-supplied
//   def apply[A](items: Iterator[A], f: Function1[A, Boolean]) =
//     AlwaysAct(items.next, f)((bool: Boolean) => status = true, (bool: Boolean) => status = false)

// }
