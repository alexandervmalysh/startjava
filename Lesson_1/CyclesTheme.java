import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод ASCII-символов");
        System.out.printf("%7s%12s%14s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        for (int code = 33; code <= 122; code++) {
            boolean isSpecialCode = (code % 2 != 0 && code <= 47) || 
                    (code % 2 == 0 && code >= 97 && code <= 122);

            if (isSpecialCode) {
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
        for (int i = maxNumber - 1; i > minNumber; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n6. Разные операции над числом");
        int initialNumber = 2_234_321;
        int currNumber = initialNumber;
        int reversedNumber = 0;
        int countOfTwos = 0;

        while (currNumber > 0) {
            int digit = currNumber % 10;
            if (digit == 2) {
                countOfTwos++;
            }
            reversedNumber = reversedNumber * 10 + digit;
            currNumber /= 10;
        }

        boolean isPolindrome = initialNumber == reversedNumber;
        String evenOrOdd = (countOfTwos % 2 == 0) ? "четным" : "нечетным";

        System.out.println(reversedNumber + " - " + (isPolindrome ? "" : "не ") + "палиндром с " + 
                evenOrOdd + " (" + countOfTwos + ") количеством двоек");

        System.out.println("\n7. Проверка счастливого числа");
        initialNumber = 101_002;
        int firstHalf = initialNumber / 1000;
        int secondHalf = initialNumber % 1000;
        int firstHalfSum = 0;
        int secondHalfSum = 0;

        for (int i = 1; i <= 3; i++) {
            firstHalfSum += firstHalf % 10;
            firstHalf /= 10;

            secondHalfSum += secondHalf % 10;
            secondHalf /= 10;
        }

        boolean isLuckyNumber = firstHalfSum == secondHalfSum;

        System.out.printf("%d - %s число%n", initialNumber, isLuckyNumber ? "счастливое" : "несчастливое");
        System.out.printf("Сумма цифр %03d = %d%n", initialNumber / 1000, firstHalfSum);
        System.out.printf("Сумма цифр %03d = %d%n", initialNumber % 1000, secondHalfSum);

        System.out.println("\n8. Генератор пароля");
        int passwordLenght = 8;
        boolean hasLongPassword = passwordLenght >= 8;
        boolean hasSymbol = false;
        boolean hasDigit = false;
        boolean hasSmallLetter = false;
        boolean hasBigLetter = false;
        String password = "";
        Random rnd = new Random();

        for (int i = 1; i <= passwordLenght; i++) {
            char ch = (char) rnd.nextInt(33, 127);
            password += ch;

            if (!Character.isLetterOrDigit(ch)) {
                hasSymbol = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isLowerCase(ch)) {
                hasSmallLetter = true;
            } else if (Character.isUpperCase(ch)) {
                hasBigLetter = true;
            }
        }

        System.out.println("Пароль: " + password);
        
        String passwordStrength = "Слабый";

        if (hasLongPassword && hasSymbol && hasDigit && hasSmallLetter && hasBigLetter) {
            passwordStrength = "Надежный";
        } else if (hasLongPassword && (hasBigLetter || hasDigit)) {
            passwordStrength = "Средний";
        } 
        System.out.println("Надежность: " + passwordStrength);
    }
}