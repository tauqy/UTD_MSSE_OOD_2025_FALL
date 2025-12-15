package Purchase.Strategys.FrequentPurchasePoint.GameConsole;

import Item.GamingConsole.GameConsole;
import Item.GamingConsole.GameConsoleType;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;

public class GameConsoleFrequentPurchasePoint implements DiscountFrequentPurchasePoint {
    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        GameConsole gameConsole = (GameConsole) purchase.getItem();
        if(gameConsole.getType() == GameConsoleType.PS4 || gameConsole.getType() == GameConsoleType.XBOX){
            return 1;
        }
        throw new IllegalArgumentException("Unknown Game Console type.");
    }
}
