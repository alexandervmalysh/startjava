import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        String player1Name = console.nextLine();
        Player p1 = new Player(player1Name);

        System.out.print("Введите имя второго игрока: ");
        String player2Name = console.nextLine();
        Player p2 = new Player(player2Name);

        GuessNumber game = new GuessNumber(p1, p2);

        String answer;
        do {
            game.start();
            do {
                System.out.println("Хотите продолжить игру? [yes/no]: ");
                answer = console.nextLine().toLowerCase();
            } while (!"yes".equals(answer) && !"no".equals(answer));
        } while (!"no".equals(answer));
    }
}