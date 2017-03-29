
import patmat.Huffman._

import scala.collection.immutable.HashMap



val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
until(singleton, combine)(leaflist)


createCodeTree(string2Chars("ciao"))