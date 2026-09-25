import decorator.CouponDiscount;
import decorator.VipDiscount;
import facade.PaymentFacade;
import observer.EmailNotifier;
import observer.SmsNotifier;
import strategy.BoletoPayment;
import strategy.CreditCardPayment;
import strategy.PaymentStrategy;
import strategy.PixPayment;

public class Main {
    static void main(String[] args) {

        PaymentFacade paymentHub = new PaymentFacade();

        paymentHub.addObserver(new EmailNotifier("ulisses@email.com"));
        paymentHub.addObserver(new SmsNotifier("+55 11 91234-5678"));

        System.out.println("=== Cenário 1: VIP + Pix ===");

        double originalAmount = 200.0;

        // Decorator em ação: aplicando desconto VIP sobre o valor original
        double discountedAmount = new VipDiscount(originalAmount).getAmount();

        // Strategy em ação: método de pagamento escolhido pelo cliente
        PaymentStrategy strategy = new PixPayment("eduardo@pix.com");

        // Facade orquestra tudo
        paymentHub.processPayment(discountedAmount, strategy);

        System.out.println();

        // --- Cenário 2: Cupom de desconto + Cartão de Crédito ---
        System.out.println("=== Cenário 2: Cupom + Cartão ===");

        double price = 300.0;

        // Decorators encadeados: cupom aplicado sobre o valor original
        double afterCoupon = new CouponDiscount(price, "SAVE10", 10).getAmount();

        PaymentStrategy card = new CreditCardPayment("4111111111111111", 3);
        paymentHub.processPayment(afterCoupon, card);

        System.out.println();

        // --- Cenário 3: Boleto sem desconto ---
        System.out.println("=== Cenário 3: Boleto simples ===");

        paymentHub.processPayment(150.0, new BoletoPayment());
    }
}
