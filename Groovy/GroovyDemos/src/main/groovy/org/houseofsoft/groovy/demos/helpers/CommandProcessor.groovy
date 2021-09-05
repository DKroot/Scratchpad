package org.houseofsoft.groovy.demos.helpers

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
class CommandProcessor implements Runnable {
    @Override
    void run() {
        println 'Executing'
    }
}
