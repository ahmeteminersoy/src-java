package example.app;

import java.util.Scanner;

class Main {
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2 || num == 3 || num == 5 || num == 7 || num == 11) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0 || num % 11 == 0) {
            return false;
        }
        for (int i = 13; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int count = 0;
        int n = kb.nextInt(); // Örnek giriş
        for (int i = 1; i < Math.pow(n, 1.0 / 5); i++) {
            if (isPrime(i)) {
                for (int k = 1; k <= i; k++) {
                    if (k * Math.pow(i, 5) <= n) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
