import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        while (answer.equalsIgnoreCase("yes")) {
            System.out.print("Введите первое число: ");
            calculator.setFirstNumber(scanner.nextInt());

            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            calculator.setOperation(scanner.next().charAt(0));

            System.out.print("Введите второе число: ");
            calculator.setSecondNumber(scanner.nextInt());

            calculator.calculate();
            scanner.nextLine();

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine().toLowerCase();
            } while (!answer.equals("no") && !answer.equals("yes"));
        }
    }
}