package com.scautils

class ??[T, Default](value: T, default: Default) {
  def get(cond: Boolean) = if (cond) value else default
  def get(cond: T => Boolean) = if (cond(value)) value else default
}

object ?? {

  def apply[V, Default](value: V, default: Default) =
    new ??(value, default)

}
