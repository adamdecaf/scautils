package com.scautils
import scala.language.higherKinds

trait Monad[M[_]] extends Functor[M] {
  def point[A](a: A): M[A]
  def flatMap[A, B](a: A)(f: A => M[B]): M[B]
}

object Monad {
  def apply[M[_]](implicit M: Monad[M]) = M
}
