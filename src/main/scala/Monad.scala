package com.scautils

trait Monad extends MonadLaw

trait MonadLaw[M[A]] {
  def pure: M[A]
  def pure(a: A): M[A]
  def map(f: A => B): M[B]
}

trait Isomorphism[A,B] {
  def apply(in: A): B
  def inverse(in: B): A
}

trait IsomorphismLaw[A,B] {
  this: Isomorphism =>
  def identity(in: A): A = inverse(apply(in))
  def reverseIdentity(in: B): B = apply(inverse(in))
}
