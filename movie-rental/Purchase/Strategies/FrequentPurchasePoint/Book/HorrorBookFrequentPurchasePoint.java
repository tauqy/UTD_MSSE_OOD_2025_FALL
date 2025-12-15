package Purchase.Strategies.FrequentPurchasePoint.Book;

import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;

public class HorrorBookFrequentPurchasePoint implements DiscountFrequentPurchasePoint {
    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        return 2;
    }
}
