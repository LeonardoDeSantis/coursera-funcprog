package recfun

import scala.collection.mutable

object Main {

    val NUM_ROW = 10

    def main(args: Array[String]) {

        println("Pascal's Triangle")
        for (row <- 0 to NUM_ROW - 1) {

            printLeftSpace(row)

            printPascal(row)

            println()
        }
    }

    def printLeftSpace(currentRow: Int): Unit = {
        for (i <- currentRow to NUM_ROW + 1) print(" ")
    }

    def printPascal(r: Int): Unit = {
        for (c <- 0 to r)
            print(pascal(c, r) + " ")
    }

    /**
      * Exercise 1
      */
    def pascal(c: Int, r: Int): Int = {

        def nextPascalArray(arr: Array[Int]): Array[Int] = {

            if (arr.length == Math.max(c + 1, r + 1)) {
                arr
            } else {

                val newArray = new Array[Int](arr.length + 1)
                newArray.update(0, 1)

                for (i <- 1 to arr.length - 1) {
                    newArray.update(i, arr(i - 1) + arr(i))
                }

                newArray.update(newArray.length - 1, 1)

                nextPascalArray(newArray)
            }
        }

        def initialArray = Array(1)

        def newArr = nextPascalArray(initialArray)

        newArr(c)
    }

    /**
      * Exercise 2
      */
    def balance(chars: List[Char]): Boolean = {

        def parse(chars: List[Char], count: Int): Boolean = {

            if (chars.length == 0) {
                count == 0
            } else if (count < 0) {
                false
            } else if (chars.head == '(') {
                parse(chars.tail, count + 1)
            } else if (chars.head == ')') {
                parse(chars.tail, count - 1)
            } else {
                parse(chars.tail, count)
            }
        }

        parse(chars, 0)
    }

    /**
      * Exercise 3
      */
    def countChange(money: Int, coins: List[Int]): Int = {
        if(money == 0) {
            1
        }
        else if(money > 0 && !coins.isEmpty) {
            countChange(money - coins.head, coins) + countChange(money, coins.tail)
        }
        else {
            0
        }
    }
}
