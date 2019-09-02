package org.houseofsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperatorsDemo {

  public static void main(String[] args) {
    log.info("-10 % 3 = {}", -10 % 3);
    log.info("10 % -3 = {}", 10 % -3);
    log.info("-10 % -3 = {}", -10 % -3);
  }
}
