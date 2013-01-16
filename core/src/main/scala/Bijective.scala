package com.scautils

trait Bijective[A, B] {
  def apply(in: A): B
  def inverse(in: B): A
}

trait BijectiveLaws[A, B] {
  this: Bijective[A, B] =>

  // type <->[A, B] = {
  //   def apply: A => B
  //   def inverse: B => A
  // }

  trait <->[F[_], G[_]] {
    def apply: F[_] => G[_]
    def inverse: G[_] => F[_]
  }

  trait <-->[F[_,_], G[_,_]] {
    def apply: F[_,_] => G[_,_]
    def inverse: G[_,_] => F[_,_]
  }

  trait <--->[F[_,_,_], G[_,_,_]] {
    def apply: F[_,_,_] => G[_,_,_]
    def inverse: G[_,_,_] => F[_,_,_]
  }

  // Implicits

  def identity(in: A): A = inverse(apply(in))
  def coIdentity(in: B): B = apply(inverse(in))
}
