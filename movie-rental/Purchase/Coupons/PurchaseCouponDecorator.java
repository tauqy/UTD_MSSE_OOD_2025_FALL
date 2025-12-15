package Purchase.Coupons;

import Purchase.DiscountPurchase;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;

public class PurchaseCouponDecorator implements DiscountPurchase, DiscountFrequentPurchasePoint {
    protected DiscountPurchase priceStrategy;
    protected DiscountFrequentPurchasePoint pointStrategy;

    public PurchaseCouponDecorator(Purchase purchase){
        this.priceStrategy = purchase.getDiscountPurchase();
        this.pointStrategy = purchase.getFrequentPurchasePointStrategy();

        purchase.setDiscountPurchase(this);
        purchase.setFrequentPurchasePointStrategy(this);
    }

    @Override
    public double getPrice(Purchase purchase) {
        return this.priceStrategy.getPrice(purchase);
    }

    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        return this.pointStrategy != null ? this.pointStrategy.getFrequentPurchasePoint(purchase) : 0;
    }
}
