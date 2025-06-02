package com.github.alexandervmalysh.lesson_2_3_4.array;

public class HackingAnimation {
    private static final String ANSI_RED = "\033[0;31m";
    private static final String ANSI_GREEN = "\033[0;32m";
    private static final String ANSI_RESET = "\033[0m";

    public static void main(String[] args) throws InterruptedException {
        simulateHacking();
        checkAccess();
    }

    private static void simulateHacking() throws InterruptedException {
        char[] spinnerElements = {'-', '\\', '|', '/'};
        int len = spinnerElements.length;

        for (int i = 0; i < 3 * len; i++) {
            System.out.print("Hacking: " + spinnerElements[i % len] + "\r");
            Thread.sleep(250);
        }
    }

    private static void checkAccess() {
        boolean isAccessGranted = (int) (Math.random() * 100) > 70;
        System.out.printf("Hacking: %s%s", isAccessGranted ?
                ANSI_GREEN + "Access Granted!" : ANSI_RED + "Access Denied!", ANSI_RESET);
    }
}
