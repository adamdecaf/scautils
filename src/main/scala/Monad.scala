package com.scautils

trait Monad[M[_]] {
  def pure[A](a: A): M[A]
  def map[A,B](a: M[A])(f: A => M[B]): M[B]
}

trait MonadLaw[M[_]] {
  this: Monad[M] =>

  def map[A, B](f: A => B): M[B]
}
