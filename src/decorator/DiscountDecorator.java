package decorator;

public abstract class DiscountDecorator {

    protected final double baseAmount;

    public DiscountDecorator(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public abstract double getAmount();
}
