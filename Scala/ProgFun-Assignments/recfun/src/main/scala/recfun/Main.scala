package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (r <= 1) 1
    else if (c == 0) 1
    else if (c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def expectClosingParens(chars: List[Char], closingParens: Int): Boolean =
      if (closingParens < 0) false
      else if (chars.isEmpty) closingParens == 0
      else if (chars.head == '(') expectClosingParens(chars.tail, closingParens + 1)
      else if (chars.head == ')') expectClosingParens(chars.tail, closingParens - 1)
      else expectClosingParens(chars.tail, closingParens)

    expectClosingParens(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (money <= 0 || coins.isEmpty) 0
    else
      countChange(money, coins.tail) + // Without the coin
        (if (money == coins.head) 1 else countChange(money - coins.head, coins)) // With the coin
}
