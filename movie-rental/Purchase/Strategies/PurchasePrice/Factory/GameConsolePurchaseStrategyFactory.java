package Purchase.Strategies.PurchasePrice.Factory;

import Item.GamingConsole.GameConsole;
import Item.Item;
import Purchase.DiscountPurchase;
import Purchase.Purchase;
import Purchase.Strategies.PurchasePrice.GameConsole.GameConsolePurchaseStrategy;
import Purchase.Strategies.PurchasePrice.VideoGamePurchase.VideoGamePurchaseStrategy;

public class GameConsolePurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Purchase purchase){
        Item item = purchase.getItem();
        if(item instanceof GameConsole){
            return new GameConsolePurchaseStrategy();
        }
        throw new IllegalArgumentException("Unknown Video Game type");
    }
}
