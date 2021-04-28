package org.houseofsoft.groovy.demos


import groovy.sql.Sql

import java.sql.ResultSet

class ItasRepository {
  static void simple(Sql self, String indvSsnId, PayPeriod payPeri, Closure closure) {
    println 'simple(Sql, String, PayPeriod, Closure)'
    closure(payPeri)
  }

  static void getWrkHrs(Sql self, String indvSsnId, PayPeriod payPeri, Closure closure) {
    println 'getWrkHrs(Sql, String, PayPeriod, Closure)'
    self.query("CALL NITASUPD.SP_EMP_HRS (${indvSsnId}, ${payPeri.payPeriod}, ${payPeri.payYr})", closure)
  }
}
