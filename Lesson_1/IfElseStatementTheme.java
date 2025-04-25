import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        boolean isMale = true;

        if (!isMale) {
            System.out.println("Женский пол");
        } else {
            System.out.println("Мужской пол");
        }

        byte age = 17;

        if (age > 18) {
            System.out.println("Возраст больше 18 лет");
        } else {
            System.out.println("Возраст меньше 18 лет");
        }

        double height = 1.83;

        if (height < 1.8) {
            System.out.println("Рост меньше 180 см");
        } else {
            System.out.println("Рост больше 180 см");
        }

        System.out.println("\n2. Поиск большего числа шагов");
        int yesterdaySteps = 8649;
        int todaySteps = 6558;

        System.out.println("Количество шагов, пройденных за вчерашний день: " + yesterdaySteps);
        System.out.println("Количество шагов, пройденных за сегодняшний день: " + todaySteps);

        if (todaySteps > yesterdaySteps) {
            System.out.println("Сегодня вы прошли больше шагов, чем вчера");
        } else if (todaySteps < yesterdaySteps) {
            System.out.println("Сегодня вы прошли меньше шагов, чем вчера");
        } else {
            System.out.println("Вы прошли одинаковое количество шагов за вчерашний день и сегодня");
        }

        double averageSteps = (yesterdaySteps + todaySteps) / 2.0;
        System.out.printf("Среднее значение шагов за два дня: %.1f%n", averageSteps);

        System.out.println("\n3. Проверка количества гостей");
        int guestsCount = 7;

        if (guestsCount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestsCount < 0) {
            System.out.println("Количество гостей не может быть отрицательным!");
        } else {
            if (guestsCount % 2 == 0) {
                System.out.printf("Записалось %d гостей. Можно формировать пары для конкурсов.%n",
                         guestsCount);
            } else {
                System.out.printf("Записалось %d гостей. Нужны индивидуальные задания.%n", guestsCount);
            }
        }

        System.out.println("\n4. Определение первого символа никнейма");
        String nickname = "Voland";
        char firstLetter = nickname.charAt(0);

        System.out.println("Первый способ:");
        System.out.print("Никнейм " + nickname + " начинается ");

        if (firstLetter >= 65 && firstLetter <= 90) {
            System.out.println("с заглавной буквы '" + firstLetter + "'");
        } else if (firstLetter >= 97 && firstLetter <= 122) {
            System.out.println("со строчной буквы '" + firstLetter + "'");
        } else if (firstLetter >= 48 && firstLetter <= 57) {
            System.out.println("с цифры '" + firstLetter + "'");
        } else {
            System.out.println("с символа '" + firstLetter + "'");
        }

        System.out.println("\nВторой способ:");
        System.out.print("Никнейм " + nickname + " начинается ");
        if (Character.isUpperCase(firstLetter)) {
            System.out.println("с заглавной буквы '" + firstLetter + "'");
        } else if (Character.isLowerCase(firstLetter)) {
            System.out.println("со строчной буквы '" + firstLetter + "'");
        } else if (Character.isDigit(firstLetter)) {
            System.out.println("с цифры '" + firstLetter + "'");
        } else if (!Character.isLetterOrDigit(firstLetter)) {
            System.out.println("с символа '" + firstLetter + "'");
        }

        System.out.println("\n5. Инвентаризация");
        int dbSerialNumber = 537;
        int computerNumber = 439;

        if (dbSerialNumber == computerNumber) {
            System.out.println("[№" + dbSerialNumber + "]: компьютер на 3-м этаже в кабинете 2");
        } else {
            System.out.println("Нет полного совпадения");
            System.out.println("База данных: [№" + dbSerialNumber + "]");

            int dbSerialOnes = dbSerialNumber % 10;
            int dbSerialDozens = dbSerialNumber / 10 % 10;
            int dbSerialHundreds = dbSerialNumber / 100;

            int computerNumberOnes = computerNumber % 10;
            int computerNumberDozens = computerNumber / 10 % 10;
            int computerNumberHundreds = computerNumber / 100;

            System.out.printf("Фактический: [%s%s%s]%n", 
                    dbSerialHundreds == computerNumberHundreds ? dbSerialHundreds : "_",
                    dbSerialDozens == computerNumberDozens ? dbSerialDozens : "_",
                    dbSerialOnes == computerNumberOnes ? dbSerialOnes : "_");
        }

        System.out.println("\n6. Подсчёт начисленных банком %");
        System.out.println("\nРешение первым способом - с использованием float без округления");
        float deposit = 321_123.79f;
        float firstInterestRate = 0.05f;
        float secondInterestRate = 0.07f;
        float thirdInterestRate = 0.1f;
        float currentInterestRate = firstInterestRate;

        if (deposit >= 100_000 && deposit <= 300_000) {
            currentInterestRate = secondInterestRate;
        } else if (deposit > 300_000) {
            currentInterestRate = thirdInterestRate;
        }

        float accuredInterest = deposit * currentInterestRate;
        float totalAmount = deposit + accuredInterest;

        System.out.printf("Сумма вклада: %f руб.%n", deposit);
        System.out.printf("Сумма начисленного процента: %f руб.%n", accuredInterest);
        System.out.printf("Итоговая сумма с процентами: %f руб.%n", totalAmount);

        System.out.println("\nРешение вторым способом - с использованием BigDecimal с округлением");
        var depositBd = new BigDecimal("321123.79");
        var firstInterestRateBd = new BigDecimal("0.05");
        var secondInterestRateBd = new BigDecimal("0.07");
        var thirdInterestRateBd = new BigDecimal("0.1");
        var currentInterestRateBd = firstInterestRateBd;

        if (depositBd.compareTo(BigDecimal.valueOf(100_000)) >= 0 && 
                depositBd.compareTo(BigDecimal.valueOf(300_000)) <= 0) {
            currentInterestRateBd = secondInterestRateBd;
        } else if (depositBd.compareTo(BigDecimal.valueOf(300_000)) > 0) {
            currentInterestRateBd = thirdInterestRateBd;
        }

        var accuredInterestBd = depositBd.multiply(currentInterestRateBd).setScale(2, RoundingMode.HALF_UP);
        var totalAmountBd = depositBd.add(accuredInterestBd).setScale(2, RoundingMode.HALF_UP);

        System.out.printf("Сумма вклада: %.2f руб.%n", depositBd);
        System.out.printf("Сумма начисленного процента: %.2f руб.%n", accuredInterestBd);
        System.out.printf("Итоговая сумма с процентами: %.2f руб.%n", totalAmountBd);

        System.out.println("\n7. Определение оценки по предметам");
        byte historyPercent = 59;
        byte historyGrade = 2;

        if (historyPercent > 60 && historyPercent <= 73) {
            historyGrade = 3;
        } else if (historyPercent > 73 && historyPercent <= 91) {
            historyGrade = 4;
        } else if (historyPercent > 91 && historyPercent <= 100) {
            historyGrade = 5;
        } else if (historyPercent < 0 || historyPercent > 100) {
            System.out.println("Ошибка в итоговых % по истории!");
        }

        byte programmingPercent = 92;
        byte programmingGrade = 2;

        if (programmingPercent > 60 && programmingPercent <= 73) {
            programmingGrade = 3;
        } else if (programmingPercent > 73 && programmingPercent <= 91) {
            programmingGrade = 4;
        } else if (programmingPercent > 91 && programmingPercent <= 100) {
            programmingGrade = 5;
        } else if (programmingPercent < 0 || programmingPercent > 100) {
            System.out.println("Ошибка в итоговых % по программированию!");
        }

        float averageGrade = (historyGrade + programmingGrade) / 2.0f;
        float averagePercent = (historyPercent + programmingPercent) / 2.0f;

        System.out.printf("Оценка по истории: %d%n", historyGrade);
        System.out.printf("Оценка по программированию: %d%n", programmingGrade);
        System.out.printf("Средний балл оценок по предметам: %.2f%n", averageGrade);
        System.out.printf("Средний %% по предметам: %.2f%n", averagePercent);

        System.out.println("\n8. Расчет годовой прибыли");
        var monthlySales = new BigDecimal("13025.233");
        var monthlyRent = new BigDecimal("5123.018");
        var monthlyProductionCost = new BigDecimal("9001.729");
        var months = new BigDecimal("12");
        var annualSales = monthlySales.multiply(months);
        var annualRent = monthlyRent.multiply(months);
        var annualProductionCost = monthlyProductionCost.multiply(months);
        var annualProfit = annualSales.subtract(annualRent)
                .subtract(annualProductionCost)
                .setScale(2, RoundingMode.HALF_UP);

        if (annualProfit.compareTo(BigDecimal.valueOf(0)) <= 0) {
            System.out.printf("Прибыль за год: %.2f%n", annualProfit);
        } else {
            System.out.printf("Прибыль за год: %+.2f%n", annualProfit);
        }
    }
}




























