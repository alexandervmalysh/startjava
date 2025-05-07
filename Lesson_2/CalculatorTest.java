import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        while (answer.equalsIgnoreCase("yes")) {
            System.out.print("Введите первое число: ");
            myCalculator.setFirstNumber(scanner.nextInt());

            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            myCalculator.setOperation(scanner.next().charAt(0));

            System.out.print("Введите второе число: ");
            myCalculator.setSecondNumber(scanner.nextInt());

            myCalculator.calculate();
            scanner.nextLine();

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine();
            } while (!answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("yes"));
        }
    }
}