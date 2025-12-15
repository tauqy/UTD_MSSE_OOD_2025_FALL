package Rental.Coupons;

import Item.Book.Book;
import Item.Item;
import Item.Movie.Movie;
import Item.Music.Music;
import Rental.DiscountRental;
import Rental.Rental;

public class FiftyPercentOffRentalCoupon extends RentalCouponDecorator {

    private static final double DISCOUNT_RATE = 0.50;

    public FiftyPercentOffRentalCoupon(Rental rental){
        DiscountRental originalDiscountRental = rental.getDiscountRental();
        super(originalDiscountRental);
        rental.setDiscountRental(this);
    }

    @Override
    public double getPrice(Rental rental){
        double basePrice = super.getPrice(rental);
        Item item = rental.getItem();

        if(item instanceof Movie || item instanceof Book || item instanceof Music){
            return basePrice * DISCOUNT_RATE;
        }

        return basePrice;
    }
}
