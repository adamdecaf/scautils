package com.scautils

trait Validation[F, S] {

}

case class Success[F, S](val value: S) extends Validation[F, S]
case class Failure[F, S](val value: F) extends Validation[F, S]

object Validation {

  implicit final class ValidationOps[F, S](val validation: Validation[F, S]) extends AnyVal {

    def map[FF, SS](ff: F => FF, ss: S => SS) = validation match {
      case Success(s) => Success(ss(s))
      case Failure(f) => Failure(ff(f))
    }

  }

}
