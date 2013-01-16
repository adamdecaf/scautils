package com.scautils

trait Monoid[A] {
  def append(a1: A, a2: A): A
  def identity: A
}

object Monoid {
  def apply[A](operation: (A, A) => A)(initial: A)(implicit id: Zero[A]): Monoid[A] = new Monoid[A] {
    def append(a1: A, a2: A): A = operation(a1, a2)
    def identity = id.zero
  }
}
