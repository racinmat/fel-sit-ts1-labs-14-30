package shop;

import java.time.LocalDateTime;

public class DateTimeFactory {

    private static LocalDateTime testNow;

    private static boolean testing;

    public static void setTestNow(LocalDateTime testNow) {
        DateTimeFactory.testNow = testNow;
        testing = true;
    }

    public static void endTesting() {
        testing = false;
    }

    public static LocalDateTime getNow() {
        if (testing) {
            return testNow;
        }

        return LocalDateTime.now();
    }
}
