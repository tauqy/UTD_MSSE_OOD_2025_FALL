package Rental.Strategies.FrequentRentalPoints.Book;

import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class HorrorBookFrequentRentalPoint implements DiscountFrequentRentalPoint {
    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return 1;
    }
}
