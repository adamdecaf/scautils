package com.scautils

object ?? {

  def apply[V, Default](cond: => Boolean)(value: V, default: Default) = {
    if (cond) value
    else default
  }

}
