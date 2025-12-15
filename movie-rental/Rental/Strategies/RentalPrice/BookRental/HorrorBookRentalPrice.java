package Rental.Strategies.RentalPrice.BookRental;

import Rental.DiscountRental;
import Rental.Rental;

public class HorrorBookRentalPrice implements DiscountRental {
    @Override
    public double getPrice(Rental rental) {
        double basePrice = 0.75;
        return rental.getDaysRented() * basePrice;
    }
}
