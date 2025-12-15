package Rental.Strategies.RentalPrice.MovieRental;

import Rental.DiscountRental;
import Rental.Rental;

public class ChildrenMovieRentalPrice implements DiscountRental {

    @Override
    public double getPrice(Rental rental) {
        double basePrice = 1.5;
        double result = basePrice;
        
        if(rental.getDaysRented() > 3){
            result += (rental.getDaysRented() - 3) * basePrice;
        }

        return result;
    }
}
