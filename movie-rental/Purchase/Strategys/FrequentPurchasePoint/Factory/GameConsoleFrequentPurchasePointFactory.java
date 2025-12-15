package Purchase.Strategys.FrequentPurchasePoint.Factory;

import Item.GamingConsole.GameConsole;
import Item.GamingConsole.GameConsoleType;
import Item.Item;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Strategys.FrequentPurchasePoint.GameConsole.GameConsoleFrequentPurchasePoint;

public class GameConsoleFrequentPurchasePointFactory {
    public DiscountFrequentPurchasePoint getStrategy(Item item){
        GameConsole gameConsole = (GameConsole) item;
        if(gameConsole.getType() == GameConsoleType.PS4 || gameConsole.getType() == GameConsoleType.XBOX){
            return new GameConsoleFrequentPurchasePoint();
        }
        throw new IllegalArgumentException("Unknow Game Console type");
    }
}
