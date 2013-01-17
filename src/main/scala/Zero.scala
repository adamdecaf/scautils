package com.scautils

import scala.reflect.ClassTag
import scala.collection.immutable.{Queue, Stack}

trait Zero[Z] {
  val zero: Z
}

object Zero {
  def mzero[A](implicit zero: Zero[A]) = zero
}

object Zeros {
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

  implicit def MapZero[A, B] = new Zero[Map[A,B]] { val zero: Map[A, B] = Map[A, B]() }
  // implicit def LeftZero[A] = new Zero[Either[A, Nothing]] { val zero: Either[A, Nothing] = Left(Zero.mzero[A].zero) }
  // implicit def RightZero[A] = new Zero[Either[Nothing, A]] { val zero: Either[Nothing, A] = Right(Zero.mzero[A].zero) }
}
