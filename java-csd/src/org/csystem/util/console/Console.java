/*----------------------------------------------------------------------
	FILE        : Console.java
	AUTHOR      : Java-Feb-2022 Group
	LAST UPDATE : 10.10.2022

	Utility Console class for standard input and output operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.console;

import java.util.Scanner;

public final class Console {
    private static final Scanner ms_kb = new Scanner(System.in);
    private Console()
    {
    }

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String message)
    {
        return readInt(message, "");
    }

    public static int readInt(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);

                return Integer.parseInt(ms_kb.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errMessage);
            }
        }
    }


    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String message)
    {
        return readDouble(message, "");
    }

    public static double readDouble(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);

                return Double.parseDouble(ms_kb.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errMessage);
            }
        }
    }


    public static long readLong()
    {
        return readLong("");
    }

    public static long readLong(String message)
    {
        return readLong(message, "");
    }

    public static long readLong(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);

                return Long.parseLong(ms_kb.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errMessage);
            }
        }
    }

    //...

    public static String read(String message)
    {
        System.out.print(message);
        return ms_kb.nextLine();
    }

    public static void write(String fmt, Object...objects)
    {
        System.out.printf(fmt, objects);
    }

    public static void writeLine(String fmt, Object...objects)
    {
        write(fmt + "\n", objects);
    }

    public static void writeLine()
    {
        writeLine("\n");
    }
}

