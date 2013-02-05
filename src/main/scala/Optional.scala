package com.scautils

import java.io.{File, InputStream}
import scala.language.implicitConversions

object Optional {
  import Optionals._

  @inline def apply[A](value: A)(implicit f: A => Option[A]): Option[A] = f(value)
}

object Optionals {
  implicit def OptionalBoolean(b: Boolean): Option[Boolean] = if (b == false) None else Some(b)
  implicit def OptionalBigInt(i: BigInt): Option[BigInt]    = if (i == BigInt(0)) None else Some(i)
  implicit def OptionalByte(b: Byte): Option[Byte]          = if (b == 0.toByte) None else Some(b)
  implicit def OptionalChar(c: Char): Option[Char]          = if (c == 32.toChar) None else Some(c)
  implicit def OptionalDouble(d: Double): Option[Double]    = if (d == 0D) None else Some(d)
  implicit def OptionalFloat(f: Float): Option[Float]       = if (f == 0.0) None else Some(f)
  implicit def OptionalInt(i: Int): Option[Int]             = if (i == 0) None else Some(i)
  implicit def OptionalLong(l: Long): Option[Long]          = if (l == 0L) None else Some(l)
  implicit def OptionalShort(s: Short): Option[Short]       = if (s == 0.toShort) None else Some(s)
  implicit def OptionalString(s: String): Option[String]    = if (s.length == 0 || s.isEmpty || s == null) None else Some(s)
  implicit def OptionalUnit(u: Unit): Option[Unit]          = None
  implicit def OptionalIterable[I <: Iterable[_]](iter: I)  = if (iter.isEmpty || iter == null) None else Some(iter)

  implicit def OptionalInputStream(stream: InputStream): Option[InputStream] = try {
    val is = stream
    if (is != null && is.available() >= 0) Some(is) else None
  } catch {
    case _: Throwable => None
  }

  implicit def OptionalFileByPath(path: String): Option[File] = {
    lazy val file = new File(path)
    if (file.exists) Some(file) else None
  }

  implicit def OptionalFile(file: File): Option[File] = try {
    if (file.exists) Some(file) else None
  } catch {
    case _: Throwable => None
  }
}
