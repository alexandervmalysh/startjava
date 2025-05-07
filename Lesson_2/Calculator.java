public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private char operation;

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public void calculate() {
        double result = 0.0;

        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return;
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            case '^':
                result = 1.0;
                if (secondNumber < 0) {
                    for (int i = 0; i < -secondNumber; i++) {
                        result *= firstNumber;
                    }
                    result = 1 / result;
                } else {
                    for (int i = 0; i < secondNumber; i++) {
                        result *= firstNumber;
                    }
                }
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
            default:
                System.out.println("Ошибка: операция '&' не поддерживается");
                return;
        }
        System.out.println("Результат вычисления: " + result);
    }
}