package com.scautils

import shapeless._
import scala.language.higherKinds

object functions {

  /**
   * It'd be nice to generalize summing over all types by using monoids.

     case class Dog()
     case class Cat() // Disjoint types

     List(1,2,3,4).summ() == 10
     List(Dog(age = 12), Cat(age = 6)).summ() === 18
   */
  implicit final class TraversableAppendOps[A, T[A] <: Traversable[A]](val t: T[A]) extends AnyVal {
    def summ()(implicit z: Zero[A], s: Semigroup[A]): A = t.foldLeft(z.zero)(s.append)
    def summ(f: (A, A) => A)(implicit z: Zero[A]): A = t.foldLeft(z.zero)(f)
  }

  def plus[@specialized(Double, Int, Long) T](a: T, b: T)(implicit m: Monoid[T]): T = m.append(a, b)

  //def plus[@specialized(Double, Int, Long) T]


  // Then, extend it onto hlist's?
  // Perhaps it'll have to be a nice @tailrec of each elements type.
}
