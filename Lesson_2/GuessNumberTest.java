import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        String player1Name = scanner.nextLine();

        System.out.print("Введите имя второго игрока: ");
        String player2Name = scanner.nextLine();

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        GuessNumber game = new GuessNumber(player1, player2);
        game.startGame();
    }
}