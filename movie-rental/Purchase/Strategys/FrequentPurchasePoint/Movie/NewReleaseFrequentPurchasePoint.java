package Purchase.Strategys.FrequentPurchasePoint.Movie;

import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;

public class NewReleaseFrequentPurchasePoint implements DiscountFrequentPurchasePoint {
    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        return 2;
    }
}
