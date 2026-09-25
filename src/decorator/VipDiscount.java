package decorator;

public class VipDiscount extends DiscountDecorator {

    public VipDiscount(double baseAmount) {
        super(baseAmount);
    }

    /// @return
    @Override
    public double getAmount() {
        double discount = baseAmount * 0.20;
        System.out.printf("[DESCONTO VIP] -R$ %.2f (20%%)%n", discount);
        return baseAmount - discount;
    }


}
