package com.scautils

trait Node[T] {

  protected var left: Option[Node[T]]
  protected var right: Option[Node[T]]
  protected val data: Option[T]

  def leftExists: Boolean = left.isDefined
  def rightExists: Boolean = right.isDefined

  def <<(f: Node[T] => Node[T]) = foldLeft(f)
  def foldLeft(f: Node[T] => Node[T]) = left match {
    case Some(node) => left = Some(f(node))
    case None =>
  }

  def >>(f: Node[T] => Node[T]) = foldRight(f)
  def foldRight(f: Node[T] => Node[T]) = right match {
    case Some(node) => right = Some(f(node))
    case None =>
  }

}

object Node {

  def apply[T](l: Option[Node[T]], r: Option[Node[T]], item: Option[T]) = new Node[T] {
    var left = l
    var right = r
    val data = item
  }

  def empty[T]: Node[T] = this(None, None, Option.empty[T])

}
