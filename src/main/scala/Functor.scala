package com.scautils

abstract class Functor[M[_], A](protected val value: A) {
  def map[B](f: A => B): M[B]
}
