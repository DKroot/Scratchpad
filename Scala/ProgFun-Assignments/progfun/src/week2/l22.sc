package week2

object l22 {
  def intervalAggregation(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), intervalAggregation(f, combine, zero)(a+1, b))
  }                                               //> intervalAggregation: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(
                                                  //| a: Int, b: Int)Int

  def product(f: Int => Int)(a: Int, b: Int): Int = intervalAggregation(f, (x, y) => x*y, 1)(a,b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x + 1)(3, 5)                       //> res0: Int = 120

  def factorial(n: Int): Int = {
    product(x => x)(1, n)
  }                                               //> factorial: (n: Int)Int

  factorial(5)                                    //> res1: Int = 120

}