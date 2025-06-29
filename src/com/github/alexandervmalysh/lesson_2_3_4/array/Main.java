package com.github.alexandervmalysh.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        execTransactionReverser();
        execHackingAnimation();
        execFactorialCalculator();
        execArrayThresholdFilter();
        execCharTrianglePrinter();
        execUniqueArrayFiller();
        execTypewriterEffect();
    }

    //    1. РЕВЕРС БАНКОВСКИХ ТРАНЗАКЦИЙ
    public static void execTransactionReverser() {
        int[] original = new int[]{};
        int[] reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);

        original = null;
        reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);

        original = new int[]{5};
        reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);

        original = new int[]{6, 8, 9, 1};
        reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);

        original = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);
    }

    //    2. АНИМАЦИЯ ЗАГРУЗКИ
    public static void execHackingAnimation() throws InterruptedException {
        Console.printHackingResult(Arrays.simulateHacking());
    }

    //    3. ВЫЧИСЛЕНИЕ ФАКТОРИАЛА
    public static void execFactorialCalculator() {
        int[] numbers = {};
        long[] factorials = Arrays.calcFactorials(numbers);
        Console.printFactorialExpr(numbers, factorials);

        numbers = null;
        factorials = Arrays.calcFactorials(numbers);
        Console.printFactorialExpr(numbers, factorials);

        numbers = new int[]{8, 0, 9};
        factorials = Arrays.calcFactorials(numbers);
        Console.printFactorialExpr(numbers, factorials);

        numbers = new int[]{-3, 1, 7, 13};
        factorials = Arrays.calcFactorials(numbers);
        Console.printFactorialExpr(numbers, factorials);

        numbers = new int[]{-22, -0};
        factorials = Arrays.calcFactorials(numbers);
        Console.printFactorialExpr(numbers, factorials);
    }

    //    4. УДАЛЕНИЕ ЭЛЕМЕНТОВ МАССИВА, ПРЕВЫШАЮЩИХ ЗАДАННОЕ ЗНАЧЕНИЕ
    public static void execArrayThresholdFilter() {
        float[] original = Arrays.generateRandomArray();

        float[] modified = Arrays.filterAboveIndexValue(original, -1);
        Console.printArrayComparison(original, modified, -1);

        modified = Arrays.filterAboveIndexValue(original, 15);
        Console.printArrayComparison(original, modified, 15);

        modified = Arrays.filterAboveIndexValue(original, 0);
        Console.printArrayComparison(original, modified, 0);

        modified = Arrays.filterAboveIndexValue(original, 14);
        Console.printArrayComparison(original, modified, 14);
    }

    //    5. ВЫВОД ОТСОРТИРОВАННЫХ СИМВОЛОВ В ВИДЕ ТРЕУГОЛЬНИКА
    public static void execCharTrianglePrinter() {
        StringBuilder charTriangle = Arrays.buildCharTriangle('0', '9', true);
        Console.printCharTriangle(charTriangle);

        charTriangle = Arrays.buildCharTriangle('/', '!', false);
        Console.printCharTriangle(charTriangle);

        charTriangle = Arrays.buildCharTriangle('A', 'J', false);
        Console.printCharTriangle(charTriangle);
    }

    //    6. ЗАПОЛНЕНИЕ МАССИВА УНИКАЛЬНЫМИ ЧИСЛАМИ
    public static void execUniqueArrayFiller() {
        Console.printNumbers(Arrays.generateRandomUniqueSortedArray(-30, -10, 23), 23);
        Console.printNumbers(Arrays.generateRandomUniqueSortedArray(10, 50, 10), 10);
        Console.printNumbers(Arrays.generateRandomUniqueSortedArray(-34, -34, 0), 0);
        Console.printNumbers(Arrays.generateRandomUniqueSortedArray(-1, 2, -3), -3);
        Console.printNumbers(Arrays.generateRandomUniqueSortedArray(5, -8, 2), 2);
    }

    //    7. ВЫВОД ТЕКСТА С ЭФФЕКТОМ ПИШУЩЕЙ МАШИНКИ
    public static void execTypewriterEffect() throws InterruptedException {
        String enteredText = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        Console.type(Arrays.toUpperCaseRange(enteredText));

        enteredText = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        Console.type(Arrays.toUpperCaseRange(enteredText));

        enteredText = null;
        Console.type(Arrays.toUpperCaseRange(enteredText));

        enteredText = "";
        Console.type(Arrays.toUpperCaseRange(enteredText));
    }
}
