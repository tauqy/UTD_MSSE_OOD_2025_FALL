package Purchase.Strategys.FrequentPurchasePoint.Book;

import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;

public class ActionBookFrequentPurchasePoint implements DiscountFrequentPurchasePoint {
    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        return 1;
    }
}
