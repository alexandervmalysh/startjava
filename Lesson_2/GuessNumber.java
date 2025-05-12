import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private int secretNumber;
    private Scanner scanner;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        boolean continueGame = true;

        while (continueGame) {
            generateNumber();
            playGame();

            continueGame = askToContinue();
        }
    }

    private void generateNumber() {
        secretNumber = (int) (Math.random() * 100 + 1);
    }

    private void playGame() {
        boolean isGuessed = false;
        boolean isPlayer1Turn = true;

        while (!isGuessed) {
            Player currentPlayer = isPlayer1Turn ? player1 : player2;
            System.out.print(currentPlayer.getName() + ", введите число для угадывания: ");
            int playerGuess = scanner.nextInt();
            isGuessed = checkGuess(playerGuess);

            if (isGuessed) {
                System.out.println("Поздравляем, " + currentPlayer.getName() +
                        "! Вы угадали число и победили!");
            } else {
                giveHint(playerGuess);
                isPlayer1Turn = !isPlayer1Turn;
            }
        }
        scanner.nextLine();
    }

    private boolean checkGuess(int guess) {
        return guess == secretNumber;
    }

    private void giveHint(int guess) {
        if (guess < secretNumber) {
            System.out.println(guess + " меньше того, что загадал компьютер");
        } else if (guess > secretNumber) {
            System.out.println(guess + " больше того, что загадал компьютер");
        }
    }

    private boolean askToContinue() {
        while (true) {
            System.out.println("Хотите продолжить игру? [yes/no]: ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                return false;
            }
        }
    }
}