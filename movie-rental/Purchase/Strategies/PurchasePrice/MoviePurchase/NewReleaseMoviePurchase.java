package Purchase.Strategies.PurchasePrice.MoviePurchase;

import Purchase.DiscountPurchase;
import Purchase.Purchase;

public class NewReleaseMoviePurchase implements DiscountPurchase {
    @Override
    public double getPrice(Purchase purchase) {
        return 20;
    }
}
