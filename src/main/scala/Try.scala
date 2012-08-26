package com.scautils

sealed trait Try[A] {

  def isSuccess: Boolean
  def isFailure: Boolean = !isSuccess

  def map[B](f: A => B) = this match {
    case Success(e) => Success(f(e))
    case Failure(e) => Failure(e)
  }

  def fold[T](failure: A => T, success: A => T) = this match {
    case Success(obj) => success(obj)
    case Failure(obj) => failure(obj)
  }

  def fold[B](z: B)(f: (A, B) => Try[B]) = this match {
    case Success(obj) => f(obj, z)
    case Failure(_) => z
  }

}

final case class Success[A](value: A) extends Try[A] {
  def isSuccess = true
}

final case class Failure[A <: Throwable](value: A) extends Try[A] {
  def isSuccess = false
}

object Try {

  def apply[A](result: => A): Try[_] =
    try {
      return Success[A](result)
    } catch {
      case e: Throwable =>
        return Failure(e)
    }

}
