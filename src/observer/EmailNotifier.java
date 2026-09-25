package observer;

public class EmailNotifier implements PaymentObserver {

    private final String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    /// @param amount
    /// @param method
    @Override
    public void onPaymentCompleted(double amount, String method) {
        System.out.printf("[EMAIL] Enviado para %s: Pagamento de R$ %.2f via %s confirmado.%n",
                email, amount, method);
    }
}
