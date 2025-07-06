package com.github.alexandervmalysh.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        while (answer.equalsIgnoreCase("yes")) {
            System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
            String expression = scanner.nextLine();

            double result = calculator.calculate(expression);

            if (!Double.isNaN(result)) {
                String formattedResult;

                if (result == (int) result) {
                    formattedResult = String.valueOf((int) result);
                } else {
                    formattedResult = String.format("%.3f", result)
                            .replace(",", ".")
                            .replaceAll("0+$", "")
                            .replaceAll("\\.$", "");
                }

                System.out.printf("%s = %s%n", expression, formattedResult);
            }

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine().toLowerCase();
            } while (!answer.equals("no") && !answer.equals("yes"));

            System.out.println();
        }
    }
}