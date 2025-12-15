package Purchase.Strategies.PurchasePrice.Factory;

import Item.Item;
import Item.Popcorn.Popcorn;
import Purchase.DiscountPurchase;
import Purchase.Purchase;
import Purchase.Strategies.PurchasePrice.PopcornPurchase.PopcornSizePurchaseStrategy;

public class PopcornPurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Purchase purchase){
        Item item = purchase.getItem();
        if(item instanceof Popcorn){
            return new PopcornSizePurchaseStrategy();
        }
        throw new IllegalArgumentException("Unknown Popcorn Size");
    }
}
