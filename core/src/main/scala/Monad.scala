package com.scautils
import scala.language.higherKinds

trait Monad[M[_]] {
  def pure[A](a: A): M[A]
  def flatMap[A,B](f: A => M[B])(a: => M[A]): M[B]
}
