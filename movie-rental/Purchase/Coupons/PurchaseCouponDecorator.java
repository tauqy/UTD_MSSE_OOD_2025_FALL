package Purchase.Coupons;

import Item.Item;
import Purchase.DiscountPurchase;
import Purchase.Purchase;

public class PurchaseCouponDecorator implements DiscountPurchase {
    protected DiscountPurchase discountPurchase;

    public PurchaseCouponDecorator(DiscountPurchase discountPurchase){
        this.discountPurchase = discountPurchase;
    }

    @Override
    public double getPrice(Purchase purchase) {
        return this.discountPurchase.getPrice(purchase);
    }
}
