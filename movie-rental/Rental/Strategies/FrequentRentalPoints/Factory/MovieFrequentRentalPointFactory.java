package Rental.Strategies.FrequentRentalPoints.Factory;

import Item.Movie.Movie;
import Item.Movie.MovieType;
import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;
import Rental.Strategies.FrequentRentalPoints.Movie.NewReleaseMovieFrequentRentalPoint;
import Rental.Strategies.FrequentRentalPoints.Movie.RegularMovieFrequentRentalPoint;

public class MovieFrequentRentalPointFactory{

    public DiscountFrequentRentalPoint getStrategy(Rental rental) {
        Movie movie = (Movie) rental.getItem();
        MovieType movieType = movie.getMovieType();

        if (movieType == MovieType.NEW_RELEASE){
            return new NewReleaseMovieFrequentRentalPoint();
        }
        else if(movieType == MovieType.REGULAR || movieType == MovieType.CHILDREN){
            return new RegularMovieFrequentRentalPoint();
        }

        throw new IllegalArgumentException("Unknown Movie Type");
    }
}
