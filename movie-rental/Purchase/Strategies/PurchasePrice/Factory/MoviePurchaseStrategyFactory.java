package Purchase.Strategies.PurchasePrice.Factory;

import Item.Item;
import Item.Movie.Movie;
import Item.Movie.MovieType;
import Purchase.DiscountPurchase;
import Purchase.Strategies.PurchasePrice.MoviePurchase.ChildrenMoviePurchase;
import Purchase.Strategies.PurchasePrice.MoviePurchase.NewReleaseMoviePurchase;
import Purchase.Strategies.PurchasePrice.MoviePurchase.RegularMoviePurchase;

public class MoviePurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Item item){
        Movie movie = (Movie) item;
        if(movie.getMovieType() == MovieType.REGULAR){
            return new RegularMoviePurchase();
        }
        else if(movie.getMovieType() == MovieType.NEW_RELEASE){
            return new NewReleaseMoviePurchase();
        }
        else if(movie.getMovieType() == MovieType.CHILDREN){
            return new ChildrenMoviePurchase();
        }
        throw new IllegalArgumentException("Unknown Movie type.");
    }
}
