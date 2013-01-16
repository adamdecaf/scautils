package com.scautils

object AlwaysAct {

 def apply[A](value: A, cond: A => Boolean)(onTrue: A => Unit, onFalse: A => Unit): Unit = {
    if (cond(value)) onTrue(value)
    else onFalse(value)
  }

}
