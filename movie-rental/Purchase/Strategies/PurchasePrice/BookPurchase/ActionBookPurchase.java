package Purchase.Strategies.PurchasePrice.BookPurchase;

import Purchase.DiscountPurchase;
import Purchase.Purchase;

public class ActionBookPurchase implements DiscountPurchase {
    @Override
    public double getPrice(Purchase purchase) {
        return 10;
    }
}
