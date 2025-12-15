package Rental.Strategys.FrequentRentalPoints.Movie;

import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class RegularMovieFrequentRentalPoint implements DiscountFrequentRentalPoint {
    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return 1;
    }
}