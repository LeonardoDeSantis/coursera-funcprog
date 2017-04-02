
import patmat.Huffman._

import scala.collection.immutable.HashMap

val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)


encode(t1)("ab".toList)

decode(t1, encode(t1)("ab".toList))