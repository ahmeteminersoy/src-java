/*----------------------------------------------------------------------------------------------------------------------
	Homework-007-2. sorunun bir çözümü
	(İleride daha iyisi yazılacaktır)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.datetime.test;

import org.csystem.util.datetime.DateUtil;

import java.util.Random;

public class PrintRandomDateTest {
    private static void printRandomDate(Random r)
    {
        System.out.println("------------------------------------------");
        System.out.println(DateUtil.randomDate(r, 1900, 2100).toShortDateStringEN());
        System.out.println("------------------------------------------");
    }

    private static void printRandomDate()
    {
        printRandomDate(new java.util.Random());
    }
    public static void run()
    {
        java.util.Random r = new java.util.Random();
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Bir sayı giriniz:");
        int count = Integer.parseInt(kb.nextLine());

        for (int i = 0; i < count; ++i)
            printRandomDate(r);
    }
}