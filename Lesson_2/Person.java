public class Person {
    private String gender = "male";
    private String name = "Саша";
    private double height = 183;
    private double weight = 85;
    private int age = 31;

    public void walk() {
        System.out.println(name + " идет");
    }

    public void sit() {
        System.out.println(name + " сидит");
    }

    public void run() {
        System.out.println(name + " бежит");
    }

    public void speak() {
        System.out.println(name + " говорит");
    }

    public void learnJava() {
        System.out.println(name + " учит Java");
    }
}