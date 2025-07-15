package com.github.alexandervmalysh.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;

        do {
            System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
            String expression = scanner.nextLine();

            try {
                double result = Calculator.calculate(expression);
                printResult(expression, result);
            } catch (RuntimeException e) {
                // Исключение уже обработано в calculate(), просто продолжаем
            }

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine().toLowerCase();
            } while (!answer.equals("no") && !answer.equals("yes"));

            System.out.println();
        } while (answer.equals("yes"));
    }

    private static void printResult(String expression, double result) {
        String normalized = expression.trim().replaceAll("\\s+", " ");
        DecimalFormat df = new DecimalFormat("#.###");
        String formattedResult = df.format(result);
        System.out.printf("%s = %s%n", normalized, formattedResult);
    }
}
