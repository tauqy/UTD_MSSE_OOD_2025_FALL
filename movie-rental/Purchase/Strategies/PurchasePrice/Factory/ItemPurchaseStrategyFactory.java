package Purchase.Strategies.PurchasePrice.Factory;

import Item.Book.Book;
import Item.GamingConsole.GameConsole;
import Item.Item;
import Item.Movie.Movie;
import Item.Popcorn.Popcorn;
import Item.VideoGame.VideoGame;
import Purchase.DiscountPurchase;
import Purchase.Purchase;

public class ItemPurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Purchase purchase){
        Item item = purchase.getItem();
        if(item instanceof Movie){
            return new MoviePurchaseStrategyFactory().getStrategy(purchase);
        }
        else if(item instanceof Book){
            return new BookPurchaseStrategyFactory().getStrategy(purchase);
        }
        else if(item instanceof VideoGame){
            return new VideoGamePurchaseStrategyFactory().getStrategy(purchase);
        }
        else if(item instanceof GameConsole){
            return new GameConsolePurchaseStrategyFactory().getStrategy(purchase);
        }
        else if(item instanceof Popcorn){
            return new PopcornPurchaseStrategyFactory().getStrategy(purchase);
        }
        throw new IllegalArgumentException("Unknown Item type");
    }
}
