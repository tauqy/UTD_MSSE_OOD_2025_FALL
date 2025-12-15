package Purchase.Strategys.PurchasePrice.Factory;

import Item.Item;
import Item.Movie.Movie;
import Item.Movie.MovieType;
import Purchase.DiscountPurchase;
import Purchase.Strategys.PurchasePrice.MoviePurchase.ChildrenMoviePurchase;
import Purchase.Strategys.PurchasePrice.MoviePurchase.NewReleaseMoviePurchase;
import Purchase.Strategys.PurchasePrice.MoviePurchase.RegularMoviePurchase;
import Rental.DiscountRental;

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
        throw new IllegalArgumentException("Unknown Movie Type.");
    }
}
