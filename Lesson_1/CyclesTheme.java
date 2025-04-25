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
    }
}