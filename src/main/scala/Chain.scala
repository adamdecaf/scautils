package com.scautils

// The idea is you can chain any number of Chain[A]'s onto each other
// and have the results zip through...
// Notes: Create a (Chain[A] => (f: A => _) => Chain[A])* version

object Chain {
  def apply[A] =
    new Chain[A]
}

final class Chain[_] {
  def |&|: (f: _ => _) => (implicit Chain[_]) => Chain[_]
}
