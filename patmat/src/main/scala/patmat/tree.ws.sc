pack(List("a", "a", "a", "b", "c", "c", "a"))

def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => (xs1 takeWhile  (x => x == xs1.head)) ::: pack( dropW  )
}
