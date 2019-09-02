package week1

object session {
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)           //> sqrtIter: (guess: Double, x: Double)Double

  def isGoodEnough(guess: Double, x: Double) =
    improve(guess, x) == guess                    //> isGoodEnough: (guess: Double, x: Double)Boolean

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2                       //> improve: (guess: Double, x: Double)Double

  def sqrt(x: Double) = sqrtIter(1.0, x)          //> sqrt: (x: Double)Double
  
  sqrt(2)                                         //> res0: Double = 1.414213562373095
  sqrt(4)                                         //> res1: Double = 2.0
  sqrt(1e-6)                                      //> res2: Double = 0.001
  sqrt(1e60)                                      //> res3: Double = 1.0E30
  sqrt(0.001)                                     //> res4: Double = 0.03162277660168379
  sqrt(0.1e-20)                                   //> res5: Double = 3.162277660168379E-11
  sqrt(1e20)                                      //> res6: Double = 1.0E10
  sqrt(1e50)                                      //> res7: Double = 1.0E25
}