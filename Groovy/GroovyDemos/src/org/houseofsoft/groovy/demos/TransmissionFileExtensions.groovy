package org.houseofsoft.groovy.demos

class TransmissionFileExtensions {
  /**
   * Formats an integer: zero-padded
   * Migrated from `Taimefcn.cpp`: `CString IntToStr(int Number,int ndigit)`
   */
  static String formatForTransmission(Integer self, int width) {
    self.toString().padLeft(width, '0')
  }

  /**
   * Formats a double for payroll file: zero-padded with decimal point removed
   * Migrated from `Taimefcn.cpp`: `CString DblToStr(double Passed_Num,int ndigit,int deci_digit)`
   */
  static String formatForTransmission(Double self, int width, int precision) {
    sprintf("%0${width + 1}.${precision}f", self).replace('.', '')
  }
}