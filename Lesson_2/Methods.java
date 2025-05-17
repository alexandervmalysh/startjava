public class Methods {
    public static String getName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}