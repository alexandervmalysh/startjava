public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод ASCII-символов");
        System.out.printf("%7s%12s%14s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        for (int i = 33; i < 123; i++) {
            if ((i % 2 != 0 && i < 48) || 
                    (i % 2 == 0 && i > 96 && i < 123)) {
                System.out.printf("%4d%11c%12c%-20s%n", i, i, ' ', Character.getName(i));
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
    }
}