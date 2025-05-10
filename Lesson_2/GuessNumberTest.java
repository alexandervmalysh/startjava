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
        boolean continueGame = true;

        while (continueGame) {
            boolean isGuessed = false;
            boolean isPlayer1Turn = true;

            game.generateNumber();

            while (!isGuessed) {
                Player currentPlayer = isPlayer1Turn ? player1 : player2;
                System.out.print(currentPlayer.getName() + ", введите число для угадывания: ");
                int playerGuess = scanner.nextInt();
                isGuessed = game.checkGuess(playerGuess);

                if (isGuessed) {
                    System.out.println("Поздравляем, " + currentPlayer.getName() + 
                            "! Вы угадали число и победили!");
                } else {
                    game.giveHint(playerGuess);
                    isPlayer1Turn = !isPlayer1Turn;
                }
            }
            scanner.nextLine();

            while (true) {
                System.out.println("Хотите продолжить игру? [yes/no]: ");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("yes")) {
                    break;
                } else if (answer.equalsIgnoreCase("no")) {
                    continueGame = false;
                    break;
                }
            }
        }
    }
}