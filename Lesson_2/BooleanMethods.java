public class BooleanMethods {
    public boolean shouldTerminateProgram() {
        System.out.println(Method.getMethodName() + " -> программа выполняется далее или завершается?");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.println(Method.getMethodName() + " -> последовательность содержит уникальную цифру?");
        return false;
    }

    public boolean isLetterInput() {
        System.out.println(Method.getMethodName() + " -> пользователь ввел букву или что-то другое?");
        return false;
    }

    public boolean hasEqualDigits() {
        System.out.println(Method.getMethodName() + " -> в проверяемых числах, есть равные цифры?");
        return false;
    }

    public boolean hasRemainingLives() {
        System.out.println(Method.getMethodName() + " -> в игре \"Марио\" остались попытки?");
        return false;
    }

    public boolean isBlankInput() {
        System.out.println(Method.getMethodName() + 
                " -> пользователь ввёл пустую строку или из одних пробелов?");
        return false;
    }

    public boolean isEvenRoll() {
        System.out.println(Method.getMethodName() + 
                " -> на кубике, который бросил компьютер, выпало четное число?");
        return false;
    }

    public boolean isValidFilePath() {
        System.out.println(Method.getMethodName() + 
                " -> путь до файла, который вы ищите на ssd, действительный?");
        return false;
    }

    public boolean isFileExist() {
        System.out.println(Method.getMethodName() + " -> файл по указанному адресу существует?");
        return false;
    }
}
