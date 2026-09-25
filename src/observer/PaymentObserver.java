package observer;

public interface PaymentObserver {
    void onPaymentCompleted(double amount, String method);
}
