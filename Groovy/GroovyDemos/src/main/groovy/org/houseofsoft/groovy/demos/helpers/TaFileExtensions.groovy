package org.houseofsoft.groovy.demos.helpers

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

import java.sql.Timestamp
import java.time.DayOfWeek

class TaFileExtensions {
  private TaFileExtensions() {
  }

  /**
   * Formats an integer: zero-padded
   */
  static String formatForTransmission(Integer self, int width) {
    // Migrated from `Taimefcn.cpp`: `CString IntToStr(int Number,int ndigit)`

    self.toString().padLeft(width, '0')
  }

  /**
   * Formats a double: zero-padded with the decimal point removed
   */
  static String formatForTransmission(Double self, int width, int precision) {
    // Migrated from `Taimefcn.cpp`: `CString DblToStr()`

    sprintf("%0${width + 1}.${precision}f", self).replace('.', '')
  }

  /**
   * Formats hours: `hhmm`, zero-padded with fractional hour part converted to minutes
   */
  static String formatHours(Double self, int width) {
    // Migrated from `Taimefcn.cpp`: `CString DblToHrs()`

    int hours = self.intValue()
    /*
    Migration notes:
    `DblToHrs()` logic on converting non-quarter fractions to minutes that seems buggy and likely unused:
    ITAS allows entering time in quarter hour increments only.
    */
    int minutes = ((self.trunc(2) - hours)*60).round().intValue()
    (hours.toString() + minutes.toString().padLeft(2, '0')).padLeft(width, '0')
  }

  /**
   * Extracts day of the week's code from a Timestamp
   * @return 1 = Sunday, 2 = Monday, to 7 = Saturday
   */
  @CompileStatic(TypeCheckingMode.SKIP) // required to use extension method(s)
  static String getWeekDayCode(Timestamp self) {
    // `DayOfWeek` enum: 7 = Sunday, 1 = Monday, to 6 = Saturday (ISO-8601)
    def dayOfWeek = self.toLocalDate().dayOfWeek
    (dayOfWeek == DayOfWeek.SUNDAY ? 1 : dayOfWeek.value + 1)
  }
}