package com.scautils

object ScaImplicits {

  implicit def flattenIterables(iter: Iterable[Iterable[_]]): Iterable[_] =
    iter.flatten

}
