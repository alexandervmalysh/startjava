public class GuessNumber {
    private Player player1;
    private Player player2;
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void generateNumber() {
        secretNumber = (int) (Math.random() * 100 + 1);
    }

    public boolean checkGuess(int guess) {
        return guess == secretNumber;
    }

    public void giveHint(int guess) {
        if (guess < secretNumber) {
            System.out.println(guess + " меньше того, что загадал компьютер");
        } else if (guess > secretNumber) {
            System.out.println(guess + " больше того, что загадал компьютер");
        }
    }
}