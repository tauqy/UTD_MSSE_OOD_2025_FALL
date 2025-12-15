package Purchase.Strategys.PurchasePrice.Factory;

import Item.Item;
import Item.VideoGame.VideoGame;
import Purchase.DiscountPurchase;
import Purchase.Strategys.PurchasePrice.VideoGamePurchase.VideoGamePurchaseStrategy;

public class VideoGamePurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Item item){
        if(item instanceof VideoGame){
            return new VideoGamePurchaseStrategy();
        }
        throw new IllegalArgumentException("Unknow Video Game Type.");
    }
}
