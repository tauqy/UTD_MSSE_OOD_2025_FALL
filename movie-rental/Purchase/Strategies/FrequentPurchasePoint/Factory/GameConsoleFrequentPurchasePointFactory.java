package Purchase.Strategies.FrequentPurchasePoint.Factory;

import Item.GamingConsole.GameConsole;
import Item.GamingConsole.GameConsoleType;
import Item.Item;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;
import Purchase.Strategies.FrequentPurchasePoint.GameConsole.GameConsoleFrequentPurchasePoint;

public class GameConsoleFrequentPurchasePointFactory {
    public DiscountFrequentPurchasePoint getStrategy(Purchase purchase){
        Item item = purchase.getItem();
        GameConsole gameConsole = (GameConsole) item;
        if(gameConsole.getType() == GameConsoleType.PS4 || gameConsole.getType() == GameConsoleType.XBOX){
            return new GameConsoleFrequentPurchasePoint();
        }
        throw new IllegalArgumentException("Unknown Game Console type");
    }
}
