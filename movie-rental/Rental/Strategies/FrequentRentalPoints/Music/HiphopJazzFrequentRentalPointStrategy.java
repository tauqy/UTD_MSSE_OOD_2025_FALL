package Rental.Strategies.FrequentRentalPoints.Music;

import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class HiphopJazzFrequentRentalPointStrategy implements DiscountFrequentRentalPoint {
    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return (rental.getDaysRented() > 1) ? 2 : 1;
    }
}
