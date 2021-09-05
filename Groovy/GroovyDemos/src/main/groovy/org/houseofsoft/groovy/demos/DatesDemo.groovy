#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import groovy.time.TimeCategory
import groovy.time.TimeDuration
import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

import java.sql.Timestamp
import java.time.*
import java.time.format.FormatStyle
import java.time.temporal.TemporalAmount

@CompileStatic(TypeCheckingMode.SKIP) // required to use categories
def main() {
  use(TimeCategory) {
    LocalDateTime ldt = LocalDateTime.now()
    println "Local date/time: ${ldt}"
    println "Date string: ${ldt.dateString}, time string: ${ldt.timeString}, date/time string: ${ldt.dateTimeString}"
    println "Formatted (`MM/dd/yyyy HH:mm:ss`): ${ldt.format('MM/dd/yyyy HH:mm:ss')}"
    println "Formatted (SHORT style): ${ldt.format(FormatStyle.SHORT)}"
    println "Formatted (MEDIUM style): ${ldt.format(FormatStyle.MEDIUM)}"
    println "Day of a week: ${ldt.dayOfWeek} (#${ldt.dayOfWeek.value})"

    Timestamp nowTimestamp = Timestamp.valueOf(ldt)
    println "Local date/time (Timestamp): ${nowTimestamp}"

    ZonedDateTime zdt = ldt << ZoneId.systemDefault()
    println "Zoned date/time: ${zdt}"
    println "Formatted (SHORT style): ${zdt.format(FormatStyle.SHORT)}"
    println "Formatted (MEDIUM style): ${zdt.format(FormatStyle.MEDIUM)}"
    println "Formatted (LONG style): ${zdt.format(FormatStyle.LONG)}"
    println "Formatted (FULL style): ${zdt.format(FormatStyle.FULL)}"

    def dayAfterTomorrow = LocalDate.now() + 2
    println "A day after tomorrow: ${dayAfterTomorrow}"

    def aMonthFromNow = LocalDate.now() + Period.ofMonths(1)
    println "A month from today: ${aMonthFromNow}"

    def threeSecondsAgo = ldt - 3
    println "3 seconds ago: ${threeSecondsAgo}"

    sleep(1000)
    LocalDateTime endLdt = LocalDateTime.now()
    TemporalAmount elapsed = ldt >> endLdt
    println "Elapsed (TemporalAmount): ${elapsed}"

    TimeDuration duration = endLdt.toDate() - ldt.toDate()
    println "Elapsed (TimeDuration): ${duration}"
  }
}

main()