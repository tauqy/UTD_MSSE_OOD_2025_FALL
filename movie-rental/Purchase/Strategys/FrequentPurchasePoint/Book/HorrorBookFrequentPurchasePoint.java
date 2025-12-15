package Purchase.Strategys.FrequentPurchasePoint.Book;

import Item.Item;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;

public class HorrorBookFrequentPurchasePoint implements DiscountFrequentPurchasePoint {
    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        return 2;
    }
}
