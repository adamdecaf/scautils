package com.scautils

trait Isomorphism[A, B] {
  def apply(in: A): B
  def inverse(in: B): A
}

trait IsomorphismLaw[A, B] {
  this: Isomorphism[A, B] =>

  def identity(in: A): A = inverse(apply(in))
  def reverseIdentity(in: B): B = apply(inverse(in))
}
