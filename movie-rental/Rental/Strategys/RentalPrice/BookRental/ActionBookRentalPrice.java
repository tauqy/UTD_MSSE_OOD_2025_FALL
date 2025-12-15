package Rental.Strategys.RentalPrice.BookRental;

import Rental.DiscountRental;
import Rental.Rental;

public class ActionBookRentalPrice implements DiscountRental {
    @Override
    public double getPrice(Rental rental) {
        double basePrice = 1.5;
        return rental.getDaysRented() * basePrice;
    }
}
