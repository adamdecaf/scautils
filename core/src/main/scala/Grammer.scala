package com.scautils
import scala.language.implicitConversions

object Grammer extends Grammer

trait Grammer {

  implicit def builder[A, AA >: A](a: AA) = new {
    def |[B, BB >: B](b: BB) = Iterable(a, b)
  }

  implicit def builder[A, AA >: A](a: Iterable[AA]) = new {
    def |[B, BB >: B](b: B) = a ++ Iterable(b)
  }

}
