package com.scautils

trait Zero[Z] {
  val zero: Z
}

object Zero {
  import scala.collection.immutable.{Queue, Stack}

  def apply[Z](item: Z)(implicit m: Manifest[Z]) = new Zero[Z] { val zero: Z = flatten1[Z](item) }
  def apply[A, Z[A]](item: Z[A])(implicit ma: Manifest[A], maz: Manifest[Z[A]]) = new Zero[Z[A]] { val zero: Z[A] = flatten2[A, Z](item) }
  // def apply[A, B, T[A, B]](item: T[A, B])(implicit ma: Manifest[A], mb: Manifest[B], mab: Manifest[T[A, B]]) = new Zero[T[A, B]] {
  //   val zero: T[A, B] = flatten3[A, B, T](item)
  // }

  private def flatten1[T](item: T)(implicit m: Manifest[T]): T = (item match {
    case x: Byte => val a: Byte = x; a
    case x: Boolean => true
    case x: Char => val a: Char = x; a
    case x: Double => 1D
    case x: Float => 1F
    case x: Int => 1
    case x: Long => 1L
    case x: String => ""
    case x: Unit => ()
  }).asInstanceOf[T]

  private def flatten2[A, T[A]](item: T[A])(implicit mA: Manifest[A], mTA: Manifest[T[A]]) = (item match {
    case x: Stack[A] => Stack[A]()
    case x: Stream[A] => Stream[A]()
    case x: Vector[A] => Vector[A]()
    case x: Array[A] => Array[A]()
    case x: List[A] => List[A]()
    case x: Option[A] => Option.empty[A]
    case x: Queue[A] => Queue[A]()
    case x: Seq[A] => Seq[A]()
    case x: Set[A] => Set[A]()
  }).asInstanceOf[T[A]]

  private def flatten3[A, B, T[A, B]](item: T[A, B])(implicit m: Manifest[T[A, B]]) = (item match {
    case x: Map[A, B] => Map[A, B]()
  }).asInstanceOf[T[A, B]]

}
