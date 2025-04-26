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

        for (int code = 33; code < 123; code++) {
            boolean isOddBeforeDigits = (code % 2 != 0 && code < 48);
            boolean isEvenLowercase =  (code % 2 == 0 && code > 96 && code < 123);

            if (isEvenLowercase || isEvenLowercase) {
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
    }
}