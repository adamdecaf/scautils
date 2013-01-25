package com.scautils

import scala.language.higherKinds
import scala.annotation.implicitNotFound
import scala.language.implicitConversions
import scala.collection.generic.CanBuildFrom

trait Inverse[+I] {
  def inverse: I
}

object Inverse {
  @implicitNotFound("No Inverse[_] typeclass found for {I}")
  def minverse[I: Inverse] = implicitly[Inverse[I]]

  @implicitNotFound("No Inverse[_] typeclass found for {I}")
  def minverse[I](i: I)(implicit f: I => Inverse[I]) = f(i)
}

object Inverses {
  implicit def UnitInverse                = new Inverse[Unit] { val inverse = () }
  implicit def BooleanInverse(i: Boolean) = new Inverse[Boolean] { val inverse = if (i) false else true }
  implicit def DoubleInverse(i: Double)   = new Inverse[Double] { val inverse = -i }
  implicit def IntInverse(i: Int)         = new Inverse[Int] { val inverse = -i }
  implicit def LongInverse(i: Long)       = new Inverse[Long] { val inverse = -i }
  implicit def FloatInverse(i: Float)     = new Inverse[Float] { val inverse = -i }
  // implicit def ShortInverse(i: Short)     = new Inverse[Short] { val inverse = -i.toShort }

  implicit def TraversableInverse[AA, T[AA] <: Traversable[AA]](xs: T[AA])(implicit i: AA => Inverse[AA], bf: CanBuildFrom[T[AA], AA, T[AA]]) = new Inverse[T[AA]] {
    val inverse = {
      val builder = bf()
      xs.foreach(e => builder += i(e).inverse)
      builder.result
    }
  }

  implicit def SomeInverse[A](s: Some[A])(implicit ss: A => Inverse[A]) = new Inverse[Some[A]] {
    val inverse = Some(ss(s.get).inverse)
  }

  implicit def NoneInverse[A, N[A] <: None.type](n: N[A]) = new Inverse[None.type] {
    val inverse = None
  }

  implicit def MapInverse[A, B](m: Map[A,B])(implicit a: A => Inverse[A], b: B => Inverse[B]) = new Inverse[Map[A,B]] {
    val inverse = m.map { case (key, value) => (a(key).inverse, b(value).inverse) }.toMap
  }
}
