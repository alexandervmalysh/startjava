import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Расчет стоимости товара");
        System.out.println("\nПервый способ решения:");
        float penPrice = 105.5f;
        float bookPrice = 235.23f;
        float dismountRate = 11.0f / 100.0f;
        float totalPrice = penPrice + bookPrice;
        float dismountAmount = totalPrice * dismountRate;
        float finalPrice = totalPrice - dismountAmount;

        System.out.println("Стомость товара без скидки: " + totalPrice + " руб.");
        System.out.println("Сумма скидки: " + dismountAmount + " руб.");
        System.out.println("Стоимость товара со скидкой: " + finalPrice + " руб.");

        System.out.println("\nВторой способ решения:");
        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.23");
        var dismountRateBd = new BigDecimal("0.11");
        var totalPriceBd = penPriceBd.add(bookPriceBd).setScale(2, RoundingMode.HALF_UP);
        var dismountAmountBd = totalPriceBd.multiply(dismountRateBd).setScale(2, RoundingMode.HALF_UP);;
        var finalPriceBd = totalPriceBd.subtract(dismountAmountBd).setScale(2, RoundingMode.HALF_UP);;

        System.out.println("Стомость товара без скидки: " + totalPriceBd + " руб.");
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
    }
}