package com.scautils
import scala.language.higherKinds

sealed trait Validation[-F, +S]

case class Success[F, S](val value: S) extends Validation[F, S]
case class Failure[F, S](val value: F) extends Validation[F, S]

object Validation {
  def apply[S](s: => S): Validation[Throwable, S] = try {
    Success(s)
  } catch {
    case t: Throwable => Failure(t)
  }
}

object ValidationOps {

  implicit final class ValidationOps[F, S](val validation: Validation[F, S]) extends AnyVal {

    def biMap[FF >: F, SS >: S](ff: F => FF , ss: S => SS): Validation[FF, SS] = validation match {
      case Success(s) => Success(ss(s))
      case Failure(f: F) => Failure(ff(f))
    }

    def map[B](f: S => B): Validation[F, B] = validation match {
      case Success(s) => Success(f(s))
      case Failure(f) => Failure(f)
    }

    def flatMap[SS >: S](f: S => Validation[F, SS]): Validation[F, SS] = validation match {
      case Success(s) => f(s)
      case Failure(f) => Failure(f)
    }

    def filter(f: S => Boolean)(implicit zeroS: Zero[S], zeroF: Zero[F]): Validation[F, S] = validation match {
      case Success(s) if (f(s)) => Success(s)
      case Success(_)           => Success(zeroS.zero)
      case Failure(_)           => Failure(zeroF.zero)
    }

    def foreach[B](f: S => B): Unit = validation match {
      case Success(s) => f(s)
      case Failure(_) => ()
    }

    def rescue(ff: F => S): Validation[F, S] = validation match {
      case Success(s) => Success(s)
      case Failure(f: F) => Success(ff(f))
    }
  }

  // Used for collecting failures along the way with a running success
  // implicit final class ValidationTraversableOps[F, S, FF[F] <: Traversable[_]](val validation: Validation[FF[F], S]) extends AnyVal {}
}
