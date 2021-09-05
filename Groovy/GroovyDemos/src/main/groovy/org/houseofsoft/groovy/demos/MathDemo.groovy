#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import java.math.RoundingMode
import java.text.DecimalFormat

def samples= [1.427987987d, 2.28d, 9.62d, 79.75d, 9411.3d]

static double truncDouble(double x, int precision) {
  new BigDecimal(String.valueOf(x)).setScale(precision, RoundingMode.DOWN).doubleValue()
}

samples.each {
  // TODO report. Groovy bug as of 3.0.8!
  println "${it}.trunc(2): ${it.trunc(2)}"

  println "Math.floor(${it}) * 100 / 100: ${Math.floor(it * 100) / 100}"

  println "(${it} - 0.005).round(2): ${(it - 0.005).round(2)}"

  println "sprintf('%5.2f', ${it}): ${sprintf("%5.2f", it)}"

  println "DecimalFormat.format(${it}): ${new DecimalFormat("#.##").format(it)}"

  println "Custom truncDouble(${it}) function: ${truncDouble(it, 2)}"

  DecimalFormat df = ["#.##"]
  df.setRoundingMode(RoundingMode.DOWN)
  println "DecimalFormat.format(${it}) with `RoundingMode.DOWN`: ${df.format(it)}\n"
}
