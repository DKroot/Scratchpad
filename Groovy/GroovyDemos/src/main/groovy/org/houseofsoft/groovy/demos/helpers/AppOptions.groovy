package org.houseofsoft.groovy.demos.helpers

import groovy.transform.ToString
import picocli.CommandLine

@CommandLine.Command(//
    name = 'ITAS-INT-NG',
    description = ['', 'ITAS INT Next Generation', ''],

    // Duplicates version in `build.gradle`: the one below is an inline constant, which can't be externalized.
    // *NOTE* Don't forget to update both.
    version = '(Version 1.0.3)',

    /*
     The ASCII art was generated with Text ASCII Art Generator (http://patorjk.com/software/taag):
     Font=`Standard`, width=`Fitted`
    */
    header = [//
        '',
        // $/ strings allow ignoring of \ within
        $/@|bold,green  ___  _____   _     ____     ___  _   _  _____    _   _   ____  |@/$,
        $/@|bold,green |_ _||_   _| / \   / ___|   |_ _|| \ | ||_   _|  | \ | | / ___| |@/$,
        $/@|bold,green  | |   | |  / _ \  \___ \    | | |  \| |  | |    |  \| || |  _  |@/$,
        $/@|bold,green  | |   | | / ___ \  ___) |   | | | |\  |  | |    | |\  || |_| | |@/$,
        $/@|bold,green |___|  |_|/_/   \_\|____/   |___||_| \_|  |_|    |_| \_| \____| |@/$,
        '' //
    ],
    //    footerHeading = '%nFor more details, see:%n',
    //    footer = ['line 1', 'line2']
    showDefaultValues = true)
@ToString(includeNames = true)
//@CompileStatic(TypeCheckingMode.SKIP) // required for a dynamic dispatch
class AppOptions {
  //region Processing options: CLI arguments, ordered alphabetically

  // Positional CLI parameter
  @CommandLine.Parameters(arity = '0..1', defaultValue = 'itasint.ini', paramLabel = 'config_profile',
      description = 'Config profile (.INI) file path')
  String iniFilePath

  /*
  Not using `defaultValue` / initialized defaults with CLI (non-Boolean) options in order to enable complex
  CLI/profile processing logic.
  */

  //noinspection GroovyUnusedAssignment // a field is required to attach `@Option`
  @CommandLine.Option(names = ['-h', '-?', '--help'], usageHelp = true, description = 'Print help and exit')
  boolean helpRequested

  @CommandLine.Option(names = '-v', description = 'Verbose: turn on additional diagnostics ([Startup] / Debug)')
  boolean debugFlag = false

  @CommandLine.Option(names = '--as',
      description = 'Save processing options to the configuration profile on exit ([Startup] / AutoSave)')
  boolean autoSaveFlag = false

  @CommandLine.Option(names = '--dn', description = 'MS SQL Database name ([DataBase] / Name)')
  String dbName

  @CommandLine.Option(names = '--dp', description = "MS SQL Database user's password ([DataBase] / Password)'")
  String dbPassword

  @CommandLine.Option(names = '--ds', description = 'MS SQL database server ([DataBase] / Source)')
  String server

  @CommandLine.Option(names = '--du', description = 'MS SQL Database user ([DataBase] / Username)')
  String dbUser

  @CommandLine.Option(names = '--em', description = 'Process an individual employee only ([Startup] / EmployeeID)')
  String employeeId

  @CommandLine.Option(names = '--go', description = 'Unattended execution: skip the menu ([Startup] / Auto)')
  // Default to unattended execution when there is no interactive terminal: running via Gradle or a CI server
  boolean unattendedFlag = false

  @CommandLine.Option(names = '--fn',
      description = ['Output base file name. The suffix {YYYY}{PP}.dat will be appended to this name.',
          '  Default: ta'])
  String outputBaseFilename

  @CommandLine.Option(names = '--pp', description = 'Pay period number ([Startup] / PayPeriod)')
  int payPeriodNum

  @CommandLine.Option(names = '--ra',
      description = 'Process all employees regardless of Transmit Date ([Startup] / RunAll)')
  boolean runAllFlag = false

  @CommandLine.Option(names = '--tk',
      description = "Process this timekeeper's employees only ([Startup] / TimekeeperID)")
  String timekeeperId

  @CommandLine.Option(names = '--yr', description = 'Pay period year ([Startup] / Year)')
  int payPeriodYear
  //endregion
}
