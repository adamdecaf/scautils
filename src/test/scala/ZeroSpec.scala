package com.scautils

import org.specs2.mutable.Specification
import scala.collection.immutable.{Queue, Stack}
import Zero._

object ZeroSpec extends Specification {

  "Using Zero" should {
    "work for the primitive types" in {
      mzero[Unit].zero    === ()
      mzero[BigInt].zero  === BigInt(0)
      mzero[Byte].zero    === 0.toByte
      mzero[Boolean].zero === false
      mzero[Char].zero    === 0.toChar
      mzero[Double].zero  === 0D
      mzero[Float].zero   === 0F
      mzero[Int].zero     === 0
      mzero[Long].zero    === 0L
      mzero[Short].zero   === 0.toShort
      mzero[String].zero  === ""
    }

    "work for types that have one type parameter" in {
      case class A()
      mzero[Stack[A]].zero  === Stack[A]()
      mzero[Stream[A]].zero === Stream[A]()
      mzero[Vector[A]].zero === Vector[A]()
      mzero[Array[A]].zero  === Array[A]()
      mzero[List[A]].zero   === List[A]()
      mzero[Option[A]].zero === Option.empty[A]
      mzero[Queue[A]].zero  === Queue[A]()
      mzero[Seq[A]].zero    === Seq[A]()
      mzero[Set[A]].zero    === Set[A]()
    }

    "work for types that have two type parameters" in {
      case class B()
      case class C()
      mzero[Map[B, C]].zero === Map[B, C]()
    }
  }

}
