package strategy;

public class BoletoPayment implements PaymentStrategy {

    /// @param amount
    @Override
    public void pay(double amount) {
        String barcode = "23793.38128 60007.827136 95000.063305 1 10010000" + (int)(amount*100);
        System.out.printf("Boleto gerado: R$ %.2f / Código: %s%n", amount, barcode);
    }
}
