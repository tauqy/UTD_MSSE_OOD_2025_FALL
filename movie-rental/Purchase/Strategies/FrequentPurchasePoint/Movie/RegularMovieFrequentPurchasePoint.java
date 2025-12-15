package Purchase.Strategies.FrequentPurchasePoint.Movie;

import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;

public class RegularMovieFrequentPurchasePoint implements DiscountFrequentPurchasePoint {
    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        return 1;
    }
}
