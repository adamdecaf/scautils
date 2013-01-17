package com.scautils

abstract class Semigroup[M[_], A](protected val value: A) {
  def append(f: A => A)(o: A): A
}
