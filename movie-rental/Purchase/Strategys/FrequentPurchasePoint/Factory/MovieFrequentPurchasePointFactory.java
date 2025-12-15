package Purchase.Strategys.FrequentPurchasePoint.Factory;

import Item.Item;
import Item.Movie.Movie;
import Item.Movie.MovieType;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Strategys.FrequentPurchasePoint.Movie.NewReleaseFrequentPurchasePoint;
import Purchase.Strategys.FrequentPurchasePoint.Movie.RegularMovieFrequentPurchasePoint;

public class MovieFrequentPurchasePointFactory {
    public DiscountFrequentPurchasePoint getStrategy(Item item){
        Movie movie = (Movie) item;
        if(movie.getMovieType() == MovieType.REGULAR || movie.getMovieType() == MovieType.CHILDREN){
            return new RegularMovieFrequentPurchasePoint();
        }
        else if(movie.getMovieType() == MovieType.NEW_RELEASE){
            return new NewReleaseFrequentPurchasePoint();
        }
        throw new IllegalArgumentException("Unknown Product Type.");
    }
}
