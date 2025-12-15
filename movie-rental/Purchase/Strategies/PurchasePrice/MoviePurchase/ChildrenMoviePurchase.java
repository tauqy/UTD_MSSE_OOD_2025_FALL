package Purchase.Strategies.PurchasePrice.MoviePurchase;

import Purchase.DiscountPurchase;
import Purchase.Purchase;

public class ChildrenMoviePurchase implements DiscountPurchase {
    @Override
    public double getPrice(Purchase purchase) {
        return 15;
    }
}
