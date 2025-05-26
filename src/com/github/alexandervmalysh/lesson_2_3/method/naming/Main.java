package com.github.alexandervmalysh.lesson_2_3.method.naming;

public class Main {
    public static void main(String[] args) {
        execNonBooleanMethods();
        execBooleanMethods();
    }

    public static void execNonBooleanMethods() {
        System.out.println("1. Не boolean-методы\n");
        NonBooleanMethods nonBm = new NonBooleanMethods();
        nonBm.findLongestWord();
        nonBm.selectMenuItem();
        nonBm.calculateAverageGrade();
        nonBm.countUniqueWords();
        nonBm.showErrorMessage();
        nonBm.syncWithCloud();
        nonBm.restoreData();
        nonBm.pauseFileDownload();
        nonBm.restoreToFactoryDefaults();
        nonBm.writeToStorage();
        nonBm.convertTemperature();
        nonBm.enterMathExpression();
        nonBm.determineRaceWinner();
        nonBm.findBooksByAuthor();
    }

    public static void execBooleanMethods() {
        System.out.println("\n2. boolean-методы\n");
        BooleanMethods bm = new BooleanMethods();
        System.out.println(bm.shouldTerminateProgram());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetterInput());
        System.out.println(bm.hasEqualDigits());
        System.out.println(bm.hasRemainingLives());
        System.out.println(bm.isBlankInput());
        System.out.println(bm.isEvenRoll());
        System.out.println(bm.isValidFilePath());
        System.out.println(bm.isFileExist());
    }
}