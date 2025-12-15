package Rental.Strategies.FrequentRentalPoints.Movie;

import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class NewReleaseMovieFrequentRentalPoint implements DiscountFrequentRentalPoint {
    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return (rental.getDaysRented() > 1) ? 2 : 1;
    }
}
