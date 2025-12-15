package Rental.Coupons;

import Item.Movie.Movie;
import Rental.DiscountRental;
import Rental.Rental;

public class FreeMovieRedemptionRentalCoupon extends RentalCouponDecorator {
    public static final int REDEMPTION_POINT_COST = 10;
    private final boolean isRedempable;

    public FreeMovieRedemptionRentalCoupon(Rental rental, double customerPointBalance) {
        DiscountRental originalDiscountRental = rental.getDiscountRental();
        super(originalDiscountRental);
        rental.setDiscountRental(this);
        this.isRedempable = customerPointBalance >= REDEMPTION_POINT_COST;
    }

    @Override
    public double getPrice(Rental rental){
        if(rental.getItem() instanceof Movie) {
            return this.isRedempable ? 0.0 : super.getPrice(rental);
        }
        throw new IllegalArgumentException("Unknown Music type");
    }
}
