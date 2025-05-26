package com.github.alexandervmalysh.lesson_2_3.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger jaegerStriker = new Jaeger();
        jaegerStriker.setModelName("Striker Eureka");
        jaegerStriker.setMark("Mark-5");
        jaegerStriker.setOrigin("Australia");
        jaegerStriker.setOperationSystem("Arbiter Tac-Conn 12");
        jaegerStriker.setEnergyCore("XIG Supercell Chamber");
        jaegerStriker.setHeight(72.2F);
        jaegerStriker.setWeight(1850F);
        jaegerStriker.setSpeed(10);
        jaegerStriker.setStrength(10);
        jaegerStriker.setArmor(9);

        System.out.println("Имя робота: " + jaegerStriker.getModelName() + "\n" +
                "Поколение: " + jaegerStriker.getMark() + "\n" +
                "Происхождение: " + jaegerStriker.getOrigin() + "\n" +
                "Операционная система: " + jaegerStriker.getOperationSystem() + "\n" +
                "Энергетическое ядро: " + jaegerStriker.getEnergyCore() + "\n" +
                "Высота: " + jaegerStriker.getHeight() + " метров\n" +
                "Масса: " + jaegerStriker.getWeight() + " тонн\n" +
                "Скорость: " + jaegerStriker.getSpeed() + "\n" +
                "Сила: " + jaegerStriker.getStrength() + "\n" +
                "Броня: " + jaegerStriker.getArmor());
        jaegerStriker.move();
        jaegerStriker.scanKaiju();

        Jaeger jaegerCherno = new Jaeger("Cherno Alpha", "Mark-1", "Russia", "Pozhar Protyev 6.4",
                "Stun Core 08", 85.34F, 2412F, 3, 10, 10);

        System.out.println("\nИмя робота: " + jaegerCherno.getModelName() + "\n" +
                "Поколение: " + jaegerCherno.getMark() + "\n" +
                "Происхождение: " + jaegerCherno.getOrigin() + "\n" +
                "Операционная система: " + jaegerCherno.getOperationSystem() + "\n" +
                "Энергетическое ядро: " + jaegerCherno.getEnergyCore() + "\n" +
                "Высота: " + jaegerCherno.getHeight() + " метров\n" +
                "Масса: " + jaegerCherno.getWeight() + " тонн\n" +
                "Скорость: " + jaegerCherno.getSpeed() + "\n" +
                "Сила: " + jaegerCherno.getStrength() + "\n" +
                "Броня: " + jaegerCherno.getArmor());
        jaegerCherno.move();
        jaegerCherno.scanKaiju();
    }
}