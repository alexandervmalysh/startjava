public class Wolf {
    String gender;
    String nickname;
    double weight;
    int age;
    String color;

    public void walk() {
        System.out.println(nickname + " идет");
    }

    public void sit() {
        System.out.println(nickname + " сидит");
    }

    public void run() {
        System.out.println(nickname + " бежит");
    }

    public void howl() {
        System.out.println(nickname + " воет");
    }

    public void hunt() {
        System.out.println(nickname + " охотится");
    }
}