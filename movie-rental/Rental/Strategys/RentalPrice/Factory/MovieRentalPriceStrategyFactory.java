package Rental.Strategys.RentalPrice.Factory;

import Item.Item;
import Item.Movie.Movie;
import Item.Movie.MovieType;
import Rental.DiscountRental;
import Rental.Rental;
import Rental.Strategys.RentalPrice.MovieRental.ChildrenMovieRentalPrice;
import Rental.Strategys.RentalPrice.MovieRental.NewReleaseMovieRentalPrice;
import Rental.Strategys.RentalPrice.MovieRental.RegularMovieRentalPrice;

public class MovieRentalPriceStrategyFactory {

    public DiscountRental getStrategy(Rental rental){
        Item item = rental.getItem();
        Movie movie = (Movie) item;
        if(movie.getMovieType() == MovieType.REGULAR){
            return new RegularMovieRentalPrice();
        }
        else if(movie.getMovieType() == MovieType.CHILDREN){
            return new ChildrenMovieRentalPrice();
        }
        else if(movie.getMovieType() == MovieType.NEW_RELEASE){
            return new NewReleaseMovieRentalPrice();
        }
        throw new IllegalArgumentException("Unknow Movie type.");
    }
}
