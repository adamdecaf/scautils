package com.scautils

import scala.language.higherKinds
import scala.annotation.implicitNotFound
import scala.language.implicitConversions
import scala.collection.generic.CanBuildFrom

trait Inverse[I] {
  def inverse: I
}

object Inverse {
  def minverse[I: Inverse] = implicitly[Inverse[I]]
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

  @implicitNotFound("Can not find typeclass for {AA}")
  implicit def TraversableInverse[AA, T[AA] <: Traversable[AA]](xs: T[AA])(implicit i: AA => Inverse[AA], bf: CanBuildFrom[T[AA], AA, T[AA]]) = new Inverse[T[AA]] {
    val inverse = {
      val builder = bf()
      xs.foreach(e => builder += i(e).inverse)
      builder.result
    }
  }
}
