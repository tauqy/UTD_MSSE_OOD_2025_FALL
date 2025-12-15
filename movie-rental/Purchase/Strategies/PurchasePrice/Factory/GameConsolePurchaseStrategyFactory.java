package Purchase.Strategies.PurchasePrice.Factory;

import Item.GamingConsole.GameConsole;
import Item.Item;
import Purchase.DiscountPurchase;
import Purchase.Strategies.PurchasePrice.VideoGamePurchase.VideoGamePurchaseStrategy;

public class GameConsolePurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Item item){
        if(item instanceof GameConsole){
            return new VideoGamePurchaseStrategy();
        }
        throw new IllegalArgumentException("Unknown Video Game type");
    }
}
