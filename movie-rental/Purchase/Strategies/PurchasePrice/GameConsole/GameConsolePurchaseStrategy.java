package Purchase.Strategies.PurchasePrice.GameConsole;

import Item.GamingConsole.GameConsole;
import Item.GamingConsole.GameConsoleType;
import Purchase.DiscountPurchase;
import Purchase.Purchase;

public class GameConsolePurchaseStrategy implements DiscountPurchase {
    @Override
    public double getPrice(Purchase purchase) {
        GameConsole gameConsole = (GameConsole) purchase.getItem();

        if(gameConsole.getType() == GameConsoleType.PS4){
            return 700;
        }
        else if(gameConsole.getType() == GameConsoleType.XBOX){
            return 500;
        }
        throw new IllegalArgumentException("Unknown GameConsole Type.");
    }
}
