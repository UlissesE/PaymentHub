package decorator;

public class CouponDiscount extends DiscountDecorator {

    private final String couponCode;

    private final double percentOff;

    public CouponDiscount(double baseAmount, String couponCode, double percentOff) {
        super(baseAmount);
        this.couponCode = couponCode;
        this.percentOff = percentOff;
    }

    /// @return
    @Override
    public double getAmount() {
        double discount = baseAmount * (percentOff / 100);
        System.out.printf("[CUPOM %S] -R$ %.2f (%.0f%%)%n", couponCode, discount, percentOff);
        return baseAmount - discount;
    }
}
