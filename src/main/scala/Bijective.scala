package com.scautils

trait Bijective[A, B] {
  def apply(in: A): B
  def inverse(in: B): A
}

trait BijectiveLaws[A, B] {
  this: Bijective[A, B] =>

  def identity(in: A): A = inverse(apply(in))
  def coIdentity(in: B): B = apply(inverse(in))
}
