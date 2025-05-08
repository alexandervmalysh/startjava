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
        if (operation != '+' && operation != '-' && operation != '*' &&
                operation != '/' && operation != '^' && operation != '%') {
            System.out.println("Ошибка: операция " + operation + " не поддерживается");
            return;
        }

        if ((operation == '/' || operation == '%') && secondNumber == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return;
        }

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
                result = firstNumber / secondNumber;
                break;
            case '^':
                result = 1.0;
                int absSecondNumber = Math.abs(secondNumber);
                for (int i = 0; i < absSecondNumber; i++) {
                    result *= firstNumber;
                }
                if (secondNumber < 0) {
                    result = 1 / result;
                }
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
            default:
                System.out.println();
                return;
        }
        System.out.println("Результат вычисления: " + result);
    }
}