package com.scautils
import scala.language.higherKinds

trait Functor[M[_]] {
  def map[A, B](a: A)(f: A => B): M[B]
}

object Functor {
  def apply[M[_]](implicit F: Functor[M]) = F
}
