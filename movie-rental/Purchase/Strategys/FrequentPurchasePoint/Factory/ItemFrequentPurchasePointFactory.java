package Purchase.Strategys.FrequentPurchasePoint.Factory;

import Item.Book.Book;
import Item.GamingConsole.GameConsole;
import Item.Item;
import Item.Movie.Movie;
import Item.Popcorn.Popcorn;
import Item.VideoGame.VideoGame;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Strategys.FrequentPurchasePoint.GameConsole.GameConsoleFrequentPurchasePoint;

public class ItemFrequentPurchasePointFactory {
    public DiscountFrequentPurchasePoint getStrategy(Item item){
        if(item instanceof Movie){
            return new MovieFrequentPurchasePointFactory().getStrategy(item);
        }
        else if(item instanceof Book){
            return new BookFrequentPurchasePointFactory().getStrategy(item);
        }
        else if(item instanceof VideoGame){
            return new VideoGameFrequentPurchasePointFactory().getStrategy(item);
        }
        else if(item instanceof GameConsole){
            return new GameConsoleFrequentPurchasePointFactory().getStrategy(item);
        }
        else if(item instanceof Popcorn){
            return new PopcornFrequentPurchasePointFactory().getStrategy(item);
        }
        throw new IllegalArgumentException("Unknown Book Type");
    }
}
