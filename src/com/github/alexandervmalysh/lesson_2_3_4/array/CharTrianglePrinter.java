package com.github.alexandervmalysh.lesson_2_3_4.array;

public class CharTrianglePrinter {
    public static void main(String[] args) {
        StringBuilder charTriangle = buildCharTriangle('0', '9', true);
        printCharTriangle(charTriangle);

        charTriangle = buildCharTriangle('/', '!', false);
        printCharTriangle(charTriangle);

        charTriangle = buildCharTriangle('A', 'J', false);
        printCharTriangle(charTriangle);
    }

    private static StringBuilder buildCharTriangle(char leftBorder, char rightBorder, boolean direction) {
        if (leftBorder > rightBorder) {
            System.out.printf("Ошибка: левая граница %d > правой %d%n%n",
                    (int) leftBorder, (int) rightBorder);
            return null;
        }

        char[] chars = new char[rightBorder - leftBorder + 1];
        int len = chars.length;

        for (int i = 0; i < len; i++) {
            chars[i] = direction ? leftBorder++ : rightBorder--;
        }

        StringBuilder charTriangle = new StringBuilder();

        for (int i = 0; i < len; i++) {
            charTriangle.repeat(" ", len - 1 - i);
            charTriangle.append(chars[i]).repeat(chars[i], i * 2).append("\n");
        }

        return charTriangle;
    }

    private static void printCharTriangle(StringBuilder charTriangle) {
        if (charTriangle == null) {
            return;
        }

        System.out.println(charTriangle);
    }
}
