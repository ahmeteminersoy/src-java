package org.csystem.app.randomgenerator;

import org.csystem.randomgenerator.RandomObjectArrayFactory;
import org.csystem.util.array.ArrayUtil;
import org.csystem.util.math.MutableFraction;
import org.csystem.util.math.geometry.Circle;

import java.util.Random;
import java.util.Scanner;

public class RandomObjectArrayGeneratorApp {
    public static void run()
    {
        Random r = new Random();
        RandomObjectArrayFactory factory = new RandomObjectArrayFactory(r);
        Scanner kb = new Scanner(System.in);
        System.out.print("Dizinin eleman sayısını giriniz:");
        int count = Integer.parseInt(kb.nextLine());

        for (Object o : factory.getObjects(count)) {
            System.out.println("-----------------------------------------------------------------");
            String typeName = o.getClass().getName();
            System.out.printf("Dinamik tür ismi:%s%n", typeName);

            if (o instanceof String s)
                System.out.println(s.toUpperCase());
            else if (o instanceof Circle c)
                System.out.printf("Alan:%f%n", c.getArea());
            else if (o instanceof int [] a)
                ArrayUtil.print(a);
            else if (o instanceof Integer) {
                int a = (int)o;
                System.out.printf("%d * %d = %d%n", a, a, a * a);
            }
            else if (o instanceof Character) {
                char ch = (char)o;
                System.out.printf("ch = %c%n", ch);
            }
            else if (o instanceof Boolean) {
                boolean flag = (boolean)o;
                System.out.printf("flag = %b%n", flag);
            }
            else if (o instanceof MutableFraction f)
                System.out.printf("Real Value:%f%n", f.getRealValue());

            System.out.println("-----------------------------------------------------------------");
        }
    }
}
