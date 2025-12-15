package Purchase.Strategies.PurchasePrice.Factory;

import Item.Item;
import Item.VideoGame.VideoGame;
import Purchase.DiscountPurchase;
import Purchase.Purchase;
import Purchase.Strategies.PurchasePrice.VideoGamePurchase.VideoGamePurchaseStrategy;

public class VideoGamePurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Purchase purchase){
        Item item = purchase.getItem();
        if(item instanceof VideoGame){
            return new VideoGamePurchaseStrategy();
        }
        throw new IllegalArgumentException("Unknown Video Game Type.");
    }
}
