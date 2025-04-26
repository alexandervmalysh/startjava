public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод ASCII-символов");
        System.out.println("\nПервый вариант решения");
        System.out.printf("%7s%12s%14s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        for (int i = 33; i < 123; i++) {
            if ((i % 2 != 0 && i < 48) || 
                    (i % 2 == 0 && i > 96 && i < 123)) {
                System.out.printf("%4d%11c%12c%-20s%n", i, i, ' ', Character.getName(i));
            }
        }

        System.out.println("\nВторой вариант решения");
        System.out.printf("%7s%12s%14s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        for (int code = 33; code <= 122; code++) {
            boolean isOddBeforeDigits = (code % 2 != 0 && code <= 47);
            boolean isEvenLowercase = (code % 2 == 0 && code >= 97 && code <= 122);

            if (isOddBeforeDigits || isEvenLowercase) {
                System.out.printf("%4d%11c%12c%-20s%n", code, code, ' ', Character.getName(code));
            }
        }

        System.out.println("\n2. Вывод геометрических фигур");
        int dashes = 10;
        int stars = 5;
        int carets = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < dashes; j++) {
                System.out.print("-");
            }

            System.out.print(" ");

            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }

            System.out.print(" ");

            for (int j = 0; j < carets; j++) {
                System.out.print("^");
            }

            System.out.println();

            stars--;
            carets += 2;
        }

        System.out.println("\n3. Вывод таблицы умножения");
        System.out.print("  |");
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println("\n--+------------------------");

        for (int i = 2; i <= 9; i++) {
            System.out.print(i + " |");
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }

        System.out.println("\n4. Вывод чисел в несколько строк");
        int start = 1;
        int end = 24;
        int count = 0;

        for (int i = start; i < end; i++) {
            if (i % 2 != 0) {
                System.out.printf("%3d", i);
                count++;
                if (count == 5) {
                    System.out.println();
                    count = 0;
                }
            }
        }
        if (count > 0) {
            while (count < 5) {
                System.out.printf("%3d", 0);
                count++;
            }
            System.out.println();
        }

        System.out.println("\n5. Вывод чисел между min и max");
        int firstNumber = 10;
        int secondNumber = 5;
        int thirdNumber = -1;
        int maxNumber = firstNumber;

        if (secondNumber > maxNumber) {
            maxNumber = secondNumber;
        }
        if (thirdNumber > maxNumber) {
            maxNumber = thirdNumber;
        }

        int minNumber = firstNumber;

        if (secondNumber < minNumber) {
            minNumber = secondNumber;
        }
        if (thirdNumber < minNumber) {
            minNumber = thirdNumber;
        }

        System.out.print("Числа в интервале (" + minNumber + ", " + maxNumber + ") в порядке убывания: ");
        for (int i = maxNumber - 1; i > minNumber; i-- ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}