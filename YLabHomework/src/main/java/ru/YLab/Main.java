package ru.YLab;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        multiplicationTable();

        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String tmp = sc.next();
            stars(n, m, tmp);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(pille(n));
        }

        guessNumber();
    }

    public static void multiplicationTable() {
        for (int i = 1; i < 10; i++) {
            System.out.println("-----------");
            for (int j = 1; j < 10; j++) {
                System.out.println(i + "*" + j + "=" + i * j);
            }
        }
    }

    public static void stars(int a, int b, String tmp) {
        for (int i = 0; i < a; i++) {
            System.out.println();
            for (int j = 0; j < b; j++) {
                System.out.print(tmp);
                if (j != b - 1) {
                    System.out.print(" ");
                }
            }
        }
    }

    public static int pille(int n) {
        if (n < 3) {
            return n;
        }
        return 2 * pille(n - 1) + pille(n - 2);
    }

    public static void guessNumber() {
        int count = 9;
        int number = new Random().nextInt(99) + 1;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Я загадал число от 1 до 99. У тебя 10 попыток угадать.");
            for (int i = 1; i <= 10; i++, count--) {
                int input_number = scanner.nextInt();
                if (input_number == number) {
                    System.out.println("Ты угадал число с " + i + " попытки!");
                    break;
                } else if (input_number > number) {
                    System.out.println("Мое число меньше! У тебя осталось " + count + " попыток!");
                } else {
                    System.out.println("Мое число больше! У тебя осталось " + count + " попыток!");
                }
                if (count == 0) {
                    System.out.println("Ты не угадал");
                }
            }
        }
    }
}