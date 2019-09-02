package week2

object l25 {
  val x = new Rational(1, 3)                      //> x  : week2.Rational = 1/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  
  val y = new Rational(5, 7)                      //> y  : week2.Rational = 5/7
  x + y                                           //> res2: week2.Rational = 22/21
  
  val z = new Rational(3, 2)                      //> z  : week2.Rational = 3/2
  x - y - z                                       //> res3: week2.Rational = -79/42
  x < y                                           //> res4: Boolean = true
  x max y                                         //> res5: week2.Rational = 5/7
}

class Rational(x: Int, y:Int) {
  require(y != 0, "denominator must be non-zero")
  
  private def gcd(a: Int, b:Int): Int = if(b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  
  def numer = x
  def denom = y
  
  def + (other: Rational) =
    new Rational(numer * other.denom + denom * other.numer, denom * other.denom)
  
  def - (other: Rational) =
    this + -other
  
  def unary_- =
    new Rational(-numer, denom)
  
  def < (other: Rational) =
    numer * other.denom < other.numer * denom
  
  def max(other: Rational) =
    if (this < other) other else this
        
  override def toString =
    numer/g + "/" + denom/g
}