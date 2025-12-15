package Purchase.Strategies.PurchasePrice.Factory;

import Item.Item;
import Item.Popcorn.Popcorn;
import Purchase.DiscountPurchase;
import Purchase.Strategies.PurchasePrice.PopcornPurchase.PopcornSizePurchaseStrategy;

public class PopcornPurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Item item){
        if(item instanceof Popcorn){
            return new PopcornSizePurchaseStrategy();
        }
        throw new IllegalArgumentException("Unknown Popcorn Size");
    }
}
