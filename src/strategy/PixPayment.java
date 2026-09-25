package strategy;

public class PixPayment implements PaymentStrategy {

    private final String pixKey;

    /// @param pixKey
    public PixPayment(String pixKey) {
        this.pixKey = pixKey;
    }


    /// @param amount
    @Override
    public void pay(double amount) {
        System.out.printf("Pagamento de R$ %.2f via pix para a chave: %s%n", amount, pixKey);
    }
}
