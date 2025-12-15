package Rental.Coupons;

import Rental.DiscountRental;
import Rental.Rental;

public class RentalCouponDecorator implements DiscountRental {
    protected DiscountRental discountRental;

    public RentalCouponDecorator(DiscountRental discountRental){
        this.discountRental = discountRental;
    }

    @Override
    public double getPrice(Rental rental){
        return this.discountRental.getPrice(rental);
    }
}
