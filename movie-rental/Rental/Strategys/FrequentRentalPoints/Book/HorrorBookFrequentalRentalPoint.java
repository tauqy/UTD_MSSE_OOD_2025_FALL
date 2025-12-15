package Rental.Strategys.FrequentRentalPoints.Book;

import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class HorrorBookFrequentalRentalPoint implements DiscountFrequentRentalPoint {
    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return 1;
    }
}
