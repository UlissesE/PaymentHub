package logger;

public class PaymentLogger {

    private static volatile PaymentLogger instance;

    private PaymentLogger() {}

    public static PaymentLogger getInstance() {
        if (instance == null) {
            synchronized (PaymentLogger.class) {
                if (instance == null) {
                    instance = new PaymentLogger();
                }
            }
        }

        return instance;
    }

    public void log (String message) {
        System.out.printf("[LOG %s] %s%n", java.time.LocalTime.now().toString(), message);
    }
}
