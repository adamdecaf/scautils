package com.scautils

trait Monad[M[_]] {
  def pure[A](a: A): M[A]
}

trait MonadLaw[M[_]] {
  this: Monad[M] =>

  def map[A, B](f: A => B): M[B]
}

