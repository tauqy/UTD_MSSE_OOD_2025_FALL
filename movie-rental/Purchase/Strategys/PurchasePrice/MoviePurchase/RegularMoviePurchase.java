package Purchase.Strategys.PurchasePrice.MoviePurchase;

import Purchase.DiscountPurchase;
import Purchase.Purchase;

public class RegularMoviePurchase implements DiscountPurchase {
    @Override
    public double getPrice(Purchase purchase) {
        return 10;
    }
}
