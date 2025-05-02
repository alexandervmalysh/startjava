import java.util.Random;

public class MyFirstGame {
    public static void main(String[] args) {
        int startInterval = 1;
        int endInteraval = 100;
        Random rnd = new Random();
        int secretNumber = rnd.nextInt(startInterval, endInteraval);
        int playerGuess = (startInterval + endInteraval) / 2;

        while (true) {
            if (playerGuess == secretNumber) {
                System.out.println("Вы победили!");
                break;
            } else if (playerGuess > secretNumber) {
                System.out.println(playerGuess + " больше того, что загадал компьютер");
                endInteraval = playerGuess - 1;
            } else {
                System.out.println(playerGuess + " меньше того, что загадал компьютер");
                startInterval = playerGuess + 1;
            }
            playerGuess = (startInterval + endInteraval) / 2;
        }
    }
}