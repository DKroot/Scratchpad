# Java Demos #

## Build System ##

Gradle build is used to perform all build and deployment tasks. Here are the main tasks:

### Pre-requisites ###

* JDK 11+

### Main tasks ###

* `build` (`b`): compiles everything, processes resources, runs unit tests, packages the app JAR and distribution
  (includes -> `assemble`, `test`)
* `classes` (`cla`): compiles the app code and processes resources (-> `compileGroovy`, `processResources`)
* `test` (`te`): runs unit tests incrementally (for updated code) (-> `classes`, `testClasses`)
  * Options:
    * `--no-build-cache`: run unit tests
    * `--tests {Class}[.{method}]` run a specific test spec, e.g.
      `--tests "gov.nih.cit.itasintng.TaFileExtensionsSpec.outputAbs() should truncate doubles to precision"`
* `assemble` (`a`): compiles the app, processes resources and packages the app JAR and distribution
  (-> `classes`, `distTar`, `distZip`)
* `distZip` (`diZ`): compiles the app, and packages the distribution ZIP (-> `jar`)
* `installDist` (`iD`): install the app into `build/install/itas-int-ng/`
* `clean` (`cle`): cleans build output

### Informational tasks ###

* `properties` (`prop`): shows project properties
* `dependencies` (`depe`): shows Java dependency trees (these are also available in build scans)

### Common options ###

* `--info`: shows detailed progress. Recommended for `docker`.