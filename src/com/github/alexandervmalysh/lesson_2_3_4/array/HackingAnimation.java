package com.github.alexandervmalysh.lesson_2_3_4.array;

public class HackingAnimation {
    private static final char[] SPINNER_ELEMENTS = {'-', '\\', '|', '/'};
    private static final String ANSI_RED = "\033[0;31m";
    private static final String ANSI_GREEN = "\033[0;32m";
    private static final String ANSI_RESET = "\033[0m";
    private static final int SPINNER_CYCLES = 3;
    private static final int DELAY_MS = 250;
    private static final int ACCESS_PROBABILITY = 70;
    private static final String MSG = "Hacking: ";

    public static void main(String[] args) throws InterruptedException {
        simulateHacking();
        checkAccess();
    }

    private static void simulateHacking() throws InterruptedException {
        int len = SPINNER_ELEMENTS.length;
        for (int i = 0; i < SPINNER_CYCLES * len; i++) {
            System.out.print(MSG + SPINNER_ELEMENTS[i % len] + "\r");
            Thread.sleep(DELAY_MS);
        }
    }

    private static void checkAccess() {
        boolean isAccessGranted = (int) (Math.random() * 100) > ACCESS_PROBABILITY;
        System.out.printf(MSG + "%s%s", isAccessGranted ?
                ANSI_GREEN + "Access Granted!" : ANSI_RED + "Access Denied!", ANSI_RESET);
    }
}
