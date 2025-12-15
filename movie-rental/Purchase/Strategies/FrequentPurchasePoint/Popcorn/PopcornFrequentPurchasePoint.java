package Purchase.Strategies.FrequentPurchasePoint.Popcorn;

import Item.Popcorn.Popcorn;
import Item.Popcorn.PopcornSize;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;

public class PopcornFrequentPurchasePoint implements DiscountFrequentPurchasePoint {
    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        Popcorn popcorn = (Popcorn) purchase.getItem();
        if(popcorn.popcornSize == PopcornSize.SMALL || popcorn.popcornSize == PopcornSize.MEDIUM){
            return 1;
        }
        else if(popcorn.popcornSize == PopcornSize.LARGE || popcorn.popcornSize == PopcornSize.XLARGE){
            return 2;
        }
        throw new IllegalArgumentException("Unknown Popcorn size");
    }
}
