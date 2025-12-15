package Rental.Strategys.FrequentRentalPoints.Music;

import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class HiphipJazzFrequentRentalPointStrategy implements DiscountFrequentRentalPoint {
    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return (rental.getDaysRented() > 1) ? 2 : 1;
    }
}
