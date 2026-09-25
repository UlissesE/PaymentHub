package observer;

public class SmsNotifier implements PaymentObserver {

    private final String phone;

    public SmsNotifier(String phone) {
        this.phone = phone;
    }

    /// @param amount
    /// @param method
    @Override
    public void onPaymentCompleted(double amount, String method) {
        System.out.printf("[SMS] Enviado para %s: R$ %.2f via %s aprovado.%n",
                phone, amount, method);
    }
}
