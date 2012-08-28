package com.scautils

import scala.collection.immutable.{Queue, Stack}
import scala.reflect.ClassTag

trait Zero[Z] {
  val zero: Z

  def map[B](implicit zero: Zero[B]) = Zero.mzero[B]
  def flatMap[B](implicit zero: Zero[B]) = Zero.mzero[B]
}

trait Zeros {
  implicit def UnitZero = new Zero[Unit] { val zero = () }
  implicit def BigIntZero = new Zero[BigInt] { val zero = BigInt(0) }
  implicit def ByteZero = new Zero[Byte] { val zero = 0.toByte }
  implicit def BooleanZero = new Zero[Boolean] { val zero = false }
  implicit def CharZero = new Zero[Char] { val zero = 0.toChar }
  implicit def DoubleZero = new Zero[Double] { val zero = 0D }
  implicit def FloatZero = new Zero[Float] { val zero = 0F }
  implicit def IntZero = new Zero[Int] { val zero = 0 }
  implicit def LongZero = new Zero[Long] { val zero = 0L }
  implicit def ShortZero = new Zero[Short] { val zero = 0.toShort }
  implicit def StringZero = new Zero[String] { val zero = "" }

  implicit def StackZero[A] = new Zero[Stack[A]] { val zero: Stack[A] = Stack[A]() }
  implicit def StreamZero[A] = new Zero[Stream[A]] { val zero: Stream[A] = Stream[A]() }
  implicit def VectorZero[A] = new Zero[Vector[A]] { val zero: Vector[A] = Vector[A]() }
  implicit def ArrayZero[A: ClassTag] = new Zero[Array[A]] { val zero: Array[A] = Array[A]() }
  implicit def ListZero[A] = new Zero[List[A]] { val zero: List[A] = List[A]() }
  implicit def OptionZero[A] = new Zero[Option[A]] { val zero: Option[A] = Option.empty[A] }
  implicit def QueueZero[A] = new Zero[Queue[A]] { val zero: Queue[A] = Queue[A]() }
  implicit def SeqZero[A] = new Zero[Seq[A]] { val zero: Seq[A] = Seq[A]() }
  implicit def SetZero[A] = new Zero[Set[A]] { val zero: Set[A] = Set[A]() }
}

object Zero extends Zeros {
  def mzero[A](implicit zero: Zero[A]) = zero
}
