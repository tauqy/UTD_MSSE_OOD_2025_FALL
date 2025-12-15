package Rental.Strategies.RentalPrice.MovieRental;

import Rental.Rental;
import Rental.DiscountRental;

public class NewReleaseMovieRentalPrice implements DiscountRental {
    private double basePrice = 3;

    @Override
    public double getPrice(Rental rental) {
        return rental.getDaysRented() * basePrice;
    }
}
