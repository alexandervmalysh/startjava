public class BooleanMethods {
    public boolean shouldTerminateProgram() {
        System.out.println(Methods.getName() + " -> программа выполняется далее или завершается?");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.println(Methods.getName() + " -> последовательность содержит уникальную цифру?");
        return false;
    }

    public boolean isLetterInput() {
        System.out.println(Methods.getName() + " -> пользователь ввел букву или что-то другое?");
        return false;
    }

    public boolean hasEqualDigits() {
        System.out.println(Methods.getName() + " -> в проверяемых числах, есть равные цифры?");
        return false;
    }

    public boolean hasRemainingLives() {
        System.out.println(Methods.getName() + " -> в игре \"Марио\" остались попытки?");
        return false;
    }

    public boolean isBlankInput() {
        System.out.println(Methods.getName() +
                " -> пользователь ввёл пустую строку или из одних пробелов?");
        return false;
    }

    public boolean isEvenRoll() {
        System.out.println(Methods.getName() +
                " -> на кубике, который бросил компьютер, выпало четное число?");
        return false;
    }

    public boolean isValidFilePath() {
        System.out.println(Methods.getName() +
                " -> путь до файла, который вы ищите на ssd, действительный?");
        return false;
    }

    public boolean isFileExist() {
        System.out.println(Methods.getName() + " -> файл по указанному адресу существует?");
        return false;
    }
}