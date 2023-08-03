#!/usr/bin/env bash
set -x
java -Djava.util.logging.config.file=build/resources/test/logging.properties -ea -cp build/classes/test:lib/junit-4.11.jar:lib/hamcrest-core-1.3.jar:lib/slf4j-api-1.7.5.jar:lib/slf4j-jdk14-1.7.5.jar org.junit.runner.JUnitCore org.houseofsoft.ArraysTest