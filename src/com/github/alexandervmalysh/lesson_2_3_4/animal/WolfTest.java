package com.github.alexandervmalysh.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf myWolf = new Wolf();

        myWolf.setGender("Male");
        myWolf.setNickname("Акела");
        myWolf.setWeight(39.8);
        myWolf.setAge(9);
        myWolf.setColor("Серо-бурый");

        System.out.println("Пол: " + myWolf.getGender());
        System.out.println("Кличка: " + myWolf.getNickname());
        System.out.println("Вес: " + myWolf.getWeight());
        System.out.println("Возраст: " + myWolf.getAge());
        System.out.println("Окрас: " + myWolf.getColor());

        myWolf.walk();
        myWolf.sit();
        myWolf.run();
        myWolf.howl();
        myWolf.hunt();
    }
}