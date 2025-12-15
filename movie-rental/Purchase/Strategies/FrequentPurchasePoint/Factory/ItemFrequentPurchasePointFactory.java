package Purchase.Strategies.FrequentPurchasePoint.Factory;

import Item.Book.Book;
import Item.GamingConsole.GameConsole;
import Item.Item;
import Item.Movie.Movie;
import Item.Popcorn.Popcorn;
import Item.VideoGame.VideoGame;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;

public class ItemFrequentPurchasePointFactory {
    public DiscountFrequentPurchasePoint getStrategy(Purchase purchase){
        Item item = purchase.getItem();
        if(item instanceof Movie){
            return new MovieFrequentPurchasePointFactory().getStrategy(purchase);
        }
        else if(item instanceof Book){
            return new BookFrequentPurchasePointFactory().getStrategy(purchase);
        }
        else if(item instanceof VideoGame){
            return new VideoGameFrequentPurchasePointFactory().getStrategy(purchase);
        }
        else if(item instanceof GameConsole){
            return new GameConsoleFrequentPurchasePointFactory().getStrategy(purchase);
        }
        else if(item instanceof Popcorn){
            return new PopcornFrequentPurchasePointFactory().getStrategy(purchase);
        }
        throw new IllegalArgumentException("Unknown Item Type");
    }
}
