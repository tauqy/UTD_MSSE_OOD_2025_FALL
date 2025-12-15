package Rental.Strategys.RentalPrice.Music;

import Rental.DiscountRental;
import Rental.Rental;

public class CountryJazzRentalPriceStrategy implements DiscountRental {
    @Override
    public double getPrice(Rental rental) {
        double basePrice = 0.25;
        double result = basePrice;

        if(rental.getDaysRented() > 10){
            result += (rental.getDaysRented() - 3) * basePrice;
        }

        return result;
    }
}
