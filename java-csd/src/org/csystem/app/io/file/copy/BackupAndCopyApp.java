package org.csystem.app.io.file.copy;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkedLengthEquals;

public class BackupAndCopyApp {
    public static void main(String[] args) {
        checkedLengthEquals(args.length, 2, "Wrong number of arguments..!");
        run(args);
    }

    public static void run(String[] args) {

    }
}
