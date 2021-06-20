package org.houseofsoft.groovy.demos

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDate

@ToString(includeNames = true) @EqualsAndHashCode
class PayPeriod {
  LocalDate ppBeginDate
  LocalDate ppEndDate
  int payYr
  int payPeriod
  int suppPayPeriod    // This field is only used by supplement process
  //   holding the current pay period
  int suppPayYr      // This field is only used by supplement process
  LocalDate sppBeginDate
  LocalDate sppEndDate

  String getFullPayPeriod() {
    use TransmissionFileExtensions, {
      payYr.toString() + payPeriod.formatForTransmission(2)
    }
  }
}
