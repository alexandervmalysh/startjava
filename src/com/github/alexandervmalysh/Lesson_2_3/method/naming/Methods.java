package com.github.alexandervmalysh.lesson_2_3.method.naming;

public class Methods {
    public static String getName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}