package org.houseofsoft;

import lombok.extern.slf4j.Slf4j;

/**
 * Logging demo Pass -Djava.util.logging.config.file=bin/logging.properties to see trace and debug logging
 * 
 * @author Dmitriy "DK" Korobskiy
 */
@Slf4j
public class LoggingDemo {

    public static void main(String[] args) {
        log.trace("Trace logging");
        log.debug("Debug logging");
        log.info("Info logging");
        log.warn("Warn logging");
        try {
            throw new RuntimeException("My runtime exception");
        } catch (Exception e) {
            log.error("(Intentional) error occurred:", e);
        }
    }
}
