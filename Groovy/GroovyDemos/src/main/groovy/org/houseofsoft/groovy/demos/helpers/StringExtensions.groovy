package org.houseofsoft.groovy.demos.helpers

class StringExtensions {
  /**
   * Returns string prefix or null
   */
  static String left(String self, int length) {
    self?.substring(0, length)
  }

  /**
   * Returns string prefix before an occurrence of a boundary
   */
  static String leftBefore(String self, String boundary) {
    if (self) {
      def index = self.indexOf(boundary)
      if (index >= 0)
        return self?.substring(0, index)
    }
    self
  }
}