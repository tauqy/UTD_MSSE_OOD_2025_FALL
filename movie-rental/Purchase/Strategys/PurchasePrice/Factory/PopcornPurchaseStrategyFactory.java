package Purchase.Strategys.PurchasePrice.Factory;

import Item.Item;
import Item.Popcorn.Popcorn;
import Purchase.DiscountPurchase;
import Purchase.Strategys.PurchasePrice.PopcornPurchase.PopcornSizePurchaseStrategy;

public class PopcornPurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Item item){
        if(item instanceof Popcorn){
            return new PopcornSizePurchaseStrategy();
        }
        throw new IllegalArgumentException("Unknow Popcorn Size");
    }
}
