
package com.scautils

trait Functor[F[_]] extends FunctorLaw[F]

trait FunctorLaw[F[_]] {
  def map[A, B](f: A => B): F[B]
  def pure[A](): F[A]
}

trait ~>[F[_], G[_]] {
  def apply[A](in: F[A]): G[A]
}

trait FunctorCollection {
  def map[F[_], C[F], A, B](coll: C[F[A]], f: F[A] => F[B]): C[F[B]]
}
