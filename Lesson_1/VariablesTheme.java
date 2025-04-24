import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        final LocalTime startTime = LocalTime.now();
        final long startNano = System.nanoTime();

        System.out.println("1. Расчет стоимости товара");
        System.out.println("Первый способ решения:");
        float penPrice = 105.5f;
        float bookPrice = 235.23f;
        float dismountRate = 11.0f / 100.0f;
        float totalPrice = penPrice + bookPrice;
        float dismountAmount = totalPrice * dismountRate;
        float finalPrice = totalPrice - dismountAmount;

        System.out.println("Стоимость товара без скидки: " + totalPrice + " руб.");
        System.out.println("Сумма скидки: " + dismountAmount + " руб.");
        System.out.println("Стоимость товара со скидкой: " + finalPrice + " руб.");

        System.out.println("\nВторой способ решения:");
        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.23");
        var dismountRateBd = new BigDecimal("0.11");
        var totalPriceBd = penPriceBd.add(bookPriceBd).setScale(2, RoundingMode.HALF_UP);
        var dismountAmountBd = totalPriceBd.multiply(dismountRateBd).setScale(2, RoundingMode.HALF_UP);
        var finalPriceBd = totalPriceBd.subtract(dismountAmountBd).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Стоимость товара без скидки: " + totalPriceBd + " руб.");
        System.out.println("Сумма скидки: " + dismountAmountBd + " руб.");
        System.out.println("Стоимость товара со скидкой: " + finalPriceBd + " руб.");

        System.out.println("\n2. Вывод ASCII-графики");
        System.out.println("""
                                 /\\
               J    a  v     v  /  \\
               J   a a  v   v  /_( )\\
            J  J  aaaaa  V V  /      \\
             JJ  a     a  V  /___/\\___\\""");

        System.out.println("\n3. Тестирование датчиков перед запуском ракеты");
        byte temperature = Byte.MAX_VALUE;

        System.out.println("[Температура, °C]");
        System.out.println("Исходное: " + temperature);
        System.out.println("+1: " + ++temperature);
        System.out.println("-1: " + --temperature);

        short pressure = Short.MAX_VALUE;
        System.out.println("\n[Давление, Па]");
        System.out.println("Исходное: " + pressure);
        System.out.println("+1: " + ++pressure);
        System.out.println("-1: " + --pressure);

        char systemStatusCode = Character.MAX_VALUE;
        System.out.println("\n[Код состояния системы, \\uFFFF]");
        System.out.println("Исходное: " + (int) systemStatusCode);
        System.out.println("+1: " + (int) ++systemStatusCode);
        System.out.println("-1: " + (int) --systemStatusCode);

        int travelDistance = Integer.MAX_VALUE;
        System.out.println("\n[Пройденное расстояние, м]");
        System.out.println("Исходное: " + travelDistance);
        System.out.println("+1: " + ++travelDistance);
        System.out.println("-1: " + --travelDistance);

        long launchTime = Long.MAX_VALUE;
        System.out.println("\n[Время с момента старта, с]");
        System.out.println("Исходное: " + launchTime);
        System.out.println("+1: " + ++launchTime);
        System.out.println("-1: " + --launchTime);

        System.out.println("\n4. Перестановка значений ячеек в таблице");
        int numberOne = 2;
        int numberTwo = 5;
        System.out.println("Исходные значения переменных: ");
        System.out.println("A = " + numberOne + ", B = " + numberTwo);

        System.out.println("\nМетод: третьей переменной");
        int temp = numberOne;
        numberOne = numberTwo;
        numberTwo = temp;
        System.out.println("Результат: A1 = " + numberOne + ", B1 = " + numberTwo);

        System.out.println("\nМетод: арифметических операций");
        numberOne += numberTwo;
        numberTwo = numberOne - numberTwo;
        numberOne -= numberTwo;
        System.out.println("Результат: A1 = " + numberOne + ", B1 = " + numberTwo);

        System.out.println("\nМетод: побитовой операции");
        numberOne ^= numberTwo;
        numberTwo ^= numberOne;
        numberOne ^= numberTwo;
        System.out.println("Результат: A1 = " + numberOne + ", B1 = " + numberTwo);

        System.out.println("\n5. Декодирование сообщения");
        int code1 = 1055;
        int code2 = 1088;
        int code3 = 1080;
        int code4 = 1074;
        int code5 = 1077;
        int code6 = 1090;
        System.out.printf("%4d %4d %4d %4d %4d %4d%n", code1, code2, code3, code4, code5, code6);
        System.out.printf("%4c %4c %4c %4c %4c %4c%n", code1, code2, code3, code4, code5, code6);

        System.out.println("\n6. Анализ кода товара");
        int productCode = 123;
        int category = productCode / 100;
        int subcategory = (productCode / 10) % 10;
        int packageType = productCode % 10;
        int checksum = category + subcategory + packageType;
        int verificationCode = category * subcategory * packageType;
        System.out.println("Код товара: " + productCode);
        System.out.println("  категория товара - " + category);
        System.out.println("  подкатегория - " + subcategory);
        System.out.println("  тип упаковки - " + packageType);
        System.out.println("Контрольная сумма = " + checksum);
        System.out.println("Проверочный код = " + verificationCode);

        System.out.println("\n7. Вывод параметров JVM и ОС");
        Runtime rt = Runtime.getRuntime();
        double conversionMb = 1024.0 * 1024.0;
        int availableCpus = rt.availableProcessors();
        double totalMemory = rt.totalMemory() / conversionMb;
        double usedMemory = (rt.totalMemory() - rt.freeMemory()) / conversionMb;
        double freeMemory = rt.freeMemory() / conversionMb;
        double maxMemory = rt.maxMemory() / conversionMb;

        System.out.println("Характеристики JVM:");
        System.out.println("  Доступное число ядер: " + availableCpus);
        System.out.printf("  Выделенная память: %.1f МБ%n", totalMemory);
        System.out.printf("  Свободная память: %.1f МБ%n", freeMemory);
        System.out.printf("  Используемая память: %.1f МБ%n", usedMemory);
        System.out.printf("  Максимально доступная память: %.1f МБ%n", maxMemory);

        System.out.println("\nПараметры ОС:");
        System.out.println("  Системный диск: " + System.getProperty("user.home"));
        System.out.println("  Версия ОС: " + System.getProperty("os.version"));
        System.out.println("  Версия Java: " + System.getProperty("java.version"));
        System.out.println("  Символ разделения пути: '" + System.getProperty("file.separator") + "'");

        System.out.println("\n8. Замер работы кода");
        long finishNano = System.nanoTime();
        double durationTime = (finishNano - startNano) / 1_000_000_000.0;
        LocalTime endTime = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        System.out.println("Старт проверки: " + dtf.format(startTime));
        System.out.println("Финиш проверки: " + dtf.format(endTime));
        System.out.printf("Время работы: %.3f сек%n", durationTime);
    }
}