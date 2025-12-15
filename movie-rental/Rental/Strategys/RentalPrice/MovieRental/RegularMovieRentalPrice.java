package Rental.Strategys.RentalPrice.MovieRental;

import Rental.Rental;
import Rental.DiscountRental;

public class RegularMovieRentalPrice implements DiscountRental {

    private double basePrice = 2.0;
    private double discountPrice = 1.5;

    @Override
    public double getPrice(Rental rental) {
        double result = basePrice;
        if(rental.getDaysRented() > 2){
            result += (rental.getDaysRented() - 2) * discountPrice;
        }
        return result;
    }
}
