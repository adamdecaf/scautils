package com.scautils

trait Monad extends MonadLaw

trait MonadLaw[M[A]] {
  def pure: M[A]
  def pure(a: A): M[A]
  def map(f: A => B): M[B]
}

