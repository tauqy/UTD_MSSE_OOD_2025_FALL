package Rental.Strategys.FrequentRentalPoints.Book;

import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class ActionBookFrequentRentalPoint implements DiscountFrequentRentalPoint {
    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return rental.getDaysRented() > 2 ? 2 : 1;
    }
}
