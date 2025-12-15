package Rental.Coupons;

import Item.Movie.Movie;
import Rental.Rental;

public class FreeMovieRedemptionRentalCoupon extends RentalCouponDecorator {
    public static final int REDEMPTION_POINT_COST = 10;
    private final boolean isRedeemable;

    public FreeMovieRedemptionRentalCoupon(Rental rental, double customerPointBalance) {
        super(rental);
        this.isRedeemable = customerPointBalance >= REDEMPTION_POINT_COST;
    }

    @Override
    public double getPrice(Rental rental){
        if(rental.getItem() instanceof Movie && this.isRedeemable) {
            return 0.0;
        }
        return super.getPrice(rental);
    }

    @Override
    public int getFrequentRentalPoint(Rental rental) {
        if(rental.getItem() instanceof Movie && this.isRedeemable) {
            return -REDEMPTION_POINT_COST;
        }
        return super.getFrequentRentalPoint(rental);
    }
}
