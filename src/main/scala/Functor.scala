package com.scautils

trait Functor[F[_]] extends FunctorLaw[F]

trait FunctorLaw[F[A]] {
  def map[B](f: A => B): F[B]
  def pure: F[A]
}

trait ~>[F[_], G[_]] {
  def apply[A](in: F[A]): G[A]
}

trait FunctorCollection {
  def map[C[F[_]], A, B](coll: C[F[A]], f: F[A] => F[B]): C[F[B]]
}
