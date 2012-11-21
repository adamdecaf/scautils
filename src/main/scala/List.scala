package com.scautils

import scala.annotation.tailrec

// object Lists {

//   // Remove the instances of `r` after the first time we see it in the list.
//   def removeAfterFirstSpotting[A](l: List[A])(r: A => Boolean) = {

//     @tailrec def processList(l: List[A], r: A => Boolean, alreadySeen: Boolean) = l match {
//       case x :: xs if (alreadySeen)  => if (r(x)) processList(xs, true)
//       case x :: xs if (!alreadySeen) => if (r(x)) processList(xs, true)
//       case x :: xs                   => if (!r(x)) processList(xs, false)
//       case xs if (xs.length == 1)    => xs
//     }

//   }

// }
