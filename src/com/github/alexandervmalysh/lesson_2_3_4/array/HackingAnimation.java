package com.github.alexandervmalysh.lesson_2_3_4.array;

public class HackingAnimation {
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String RESET = "\033[0m";

    public static void main(String[] args) throws InterruptedException {
        checkAccess(simulateHacking());
    }

    private static boolean simulateHacking() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        int len = spins.length;

        System.out.print("Hacking: ");
        for (int i = 0; i < 3 * len; i++) {
            System.out.print(spins[i % len]);
            Thread.sleep(250);
            System.out.print("\b");
        }
        return (int) (Math.random() * 100) > 70;
    }

    private static void checkAccess(boolean isAccessGranted) {
        System.out.printf("%s%s", isAccessGranted
                ? GREEN + "Access Granted!"
                : RED + "Access Denied!", RESET);
    }
}
