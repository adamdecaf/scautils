package com.scautils

sealed trait Try[_] {

  def map[A, B](f: A => B): Try[_] = this match {
    case Success(e: A) => Success(f(e))
    case Failure(e: A) => Failure(e)
  }

  def fold[T](failure: Any => T, success: Any => T): T = {
    if (this.isInstanceOf[Success[_]])
      failure(this)
    else
      success(this)
  }

  val isSuccess: Boolean
  val isFailure: Boolean

}

case class Success[A](value: A) extends Try[A] {
  val isSuccess = true
  val isFailure = false
}

case class Failure[A](value: A) extends Try[A] {
  val isSuccess = false
  val isFailure = true
}

object Try {

  def apply[A](result: A) = {
    try {
      Success(result)
    } catch {
      case e => Failure(e)
    }
  }

}
