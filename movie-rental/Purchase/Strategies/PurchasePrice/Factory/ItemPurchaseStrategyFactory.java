package Purchase.Strategies.PurchasePrice.Factory;

import Item.Book.Book;
import Item.GamingConsole.GameConsole;
import Item.Item;
import Item.Movie.Movie;
import Item.Popcorn.Popcorn;
import Item.VideoGame.VideoGame;
import Purchase.DiscountPurchase;

public class ItemPurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Item item){
        if(item instanceof Movie){
            return new MoviePurchaseStrategyFactory().getStrategy(item);
        }
        else if(item instanceof Book){
            return new BookPurchaseStrategyFactory().getStrategy(item);
        }
        else if(item instanceof VideoGame){
            return new VideoGamePurchaseStrategyFactory().getStrategy(item);
        }
        else if(item instanceof GameConsole){
            return new GameConsolePurchaseStrategyFactory().getStrategy(item);
        }
        else if(item instanceof Popcorn){
            return new PopcornPurchaseStrategyFactory().getStrategy(item);
        }
        throw new IllegalArgumentException("Unknown Item type");
    }
}
