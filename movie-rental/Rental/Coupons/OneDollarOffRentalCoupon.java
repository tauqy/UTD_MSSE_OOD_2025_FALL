package Rental.Coupons;

import Item.Book.Book;
import Item.Item;
import Item.Movie.Movie;
import Item.Music.Music;
import Rental.Rental;

public class OneDollarOffRentalCoupon extends RentalCouponDecorator {

    public OneDollarOffRentalCoupon(Rental rental) {
        super(rental);
    }

    @Override
    public double getPrice(Rental rental){
        double basePrice = super.getPrice(rental);
        Item item = rental.getItem();

        if(item instanceof Movie || item instanceof Book || item instanceof Music){
            return basePrice > 5 ? basePrice - 1 : basePrice;
        }

        return basePrice;
    }
}
