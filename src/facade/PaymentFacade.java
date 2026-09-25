package facade;

import logger.PaymentLogger;
import observer.PaymentObserver;
import strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class PaymentFacade {

    private final List<PaymentObserver> observers = new ArrayList<>();
    private final PaymentLogger logger = PaymentLogger.getInstance();

    public void addObserver(PaymentObserver observer) {
        observers.add(observer);
    }

    public void processPayment(double amount, PaymentStrategy strategy) {
        logger.log(String.format("Iniciando pagamento de R$ %.2f", amount));

        strategy.pay(amount);

        String methodName = strategy.getClass().getSimpleName();
        logger.log(String.format("Pagamento via %s concluído.", methodName));

        for (PaymentObserver observer : observers) {
            observer.onPaymentCompleted(amount, methodName);
        }
    }
}
