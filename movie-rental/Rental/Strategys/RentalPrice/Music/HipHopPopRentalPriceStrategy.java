package Rental.Strategys.RentalPrice.Music;

import Rental.DiscountRental;
import Rental.Rental;

public class HipHopPopRentalPriceStrategy implements DiscountRental {
    @Override
    public double getPrice(Rental rental) {
        double basePrice = 0.5;
        double result = basePrice;

        if(rental.getDaysRented() > 5){
            result += (rental.getDaysRented() - 3) * basePrice;
        }

        return result;
    }
}
