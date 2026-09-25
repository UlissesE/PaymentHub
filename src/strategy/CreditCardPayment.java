package strategy;

public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;
    private final int installments;

    public CreditCardPayment(String cardNumber, int installments) {
        this.cardNumber = cardNumber;
        this.installments = installments;
    }


    /// @param amount
    @Override
    public void pay(double amount) {
        double installmentValue = amount / installments;
        System.out.printf(
                "Pagamento de R$ %.2f no cartão **** %s em %dx de R$ %.2f%n",
                amount, cardNumber.substring(cardNumber.length() - 4), installments, installmentValue
        );
    }
}
