package com.github.alexandervmalysh.lesson_2_3_4.method.naming;

public class Methods {
    public static String getName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}