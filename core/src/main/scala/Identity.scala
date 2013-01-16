package com.scautils

// Zero of the F[A]#A should be returned when we map over it
// map(f(g(_))) === f(map(g(_)))

// Identity Functor
// trait IdentityFunctor[F[_]] extends Functor[F] {

//   def map[A, B](zero: A)(f: A => F[B]): F[B] = f(zero)

// }
