package com.scautils

sealed trait Try[A] {

  def isSuccess: Boolean
  def isFailure: Boolean

  def map[B](f: A => B): Try[B] = this match {
    case Success(e) => Success(f(e))
    case Failure(e) => Failure(e)
  }

  def fold[T](failure: Throwable => T, success: A => T): T = this match {
    case Success(obj) => success(obj)
    case Failure(obj) => failure(obj)
  }

  def fold[B](z: B)(f: (A, B) => B): B = this match {
    case Success(obj) => f(obj, z)
    case Failure(_) => z
  }

}

final case class Success[A](value: A) extends Try[A] {
  def isSuccess = true
  def isFailure = false
}

final case class Failure[A](value: Throwable) extends Try[A] {
  def isSuccess = false
  def isFailure = true
}

object Try {

  def apply[A](result: => A) = {
    try {
      Success(result)
    } catch {
      case e => Failure(e)
    }
  }

}
