package com.scautils
import scala.language.higherKinds

abstract class Monad[M[_], A](override protected val value: A) extends Functor[M, A](value) {
  def flatMap[B](f: A => M[B]): M[B]
}
