package com.scautils

trait ~>[F[_], G[_]] {
  def apply[A](in: F[A]): G[A]
}
