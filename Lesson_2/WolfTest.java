public class WolfTest {
    public static void main(String[] args) {
        Wolf myWolf = new Wolf();

        myWolf.gender = "Male";
        myWolf.nickname = "Акела";
        myWolf.weight = 39.8;
        myWolf.age = 5;
        myWolf.color = "Cеро-бурый";

        System.out.println("Пол: " + myWolf.gender);
        System.out.println("Кличка: " + myWolf.nickname);
        System.out.println("Вес: " + myWolf.weight);
        System.out.println("Возраст: " + myWolf.age);
        System.out.println("Окрас: " + myWolf.color);

        myWolf.walk();
        myWolf.sit();
        myWolf.run();
        myWolf.howl();
        myWolf.hunt();
    }
}