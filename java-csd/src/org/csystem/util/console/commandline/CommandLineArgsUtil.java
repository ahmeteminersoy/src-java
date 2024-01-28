package org.csystem.util.console.commandline;

public class CommandLineArgsUtil {
    public static void checkedLengthEquals(int length, int num, String str)
    {
        if (length == num)
            System.exit(1);
        else
            System.out.println(str);
    }
}
