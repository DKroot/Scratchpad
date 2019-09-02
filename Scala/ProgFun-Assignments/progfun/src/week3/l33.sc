package week3

object l33 {
	def get[T](l: List[T], n: Int): T = {
	  if (l.isEmpty) throw new IndexOutOfBoundsException()
	  else if (n == 0) l.head
	  else get(l.tail, n-1)
	}                                         //> get: [T](l: week3.List[T], n: Int)T
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}