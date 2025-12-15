package Rental.Strategies.FrequentRentalPoints.Music;

import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class CountryPopFrequentRentalPointStrategy implements DiscountFrequentRentalPoint {


    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return (rental.getDaysRented() > 5) ? 2 : 1;
    }
}
