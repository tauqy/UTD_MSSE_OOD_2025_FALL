package Purchase.Strategies.FrequentPurchasePoint.Factory;

import Item.Item;
import Item.Popcorn.Popcorn;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Strategies.FrequentPurchasePoint.Popcorn.PopcornFrequentPurchasePoint;

public class PopcornFrequentPurchasePointFactory {
    public DiscountFrequentPurchasePoint getStrategy(Item item){
        Popcorn popcorn = (Popcorn) item;
        return switch (popcorn.popcornSize) {
            case SMALL, MEDIUM, LARGE, XLARGE -> new PopcornFrequentPurchasePoint();
            default -> throw new IllegalArgumentException("Unknown Popcorn size");
        };
    }
}
