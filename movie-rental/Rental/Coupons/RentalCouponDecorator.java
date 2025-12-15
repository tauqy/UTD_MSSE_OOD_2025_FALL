package Rental.Coupons;

import Rental.DiscountRental;
import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class RentalCouponDecorator implements DiscountRental, DiscountFrequentRentalPoint {
    protected DiscountRental priceStrategy;
    protected DiscountFrequentRentalPoint pointStrategy;

    public RentalCouponDecorator(Rental rental){
        this.priceStrategy = rental.getDiscountRental();
        this.pointStrategy = rental.getFrequentRentalPointStrategy();

        rental.setDiscountRental(this);
        rental.setFrequentRentalPointStrategy(this);
    }

    @Override
    public double getPrice(Rental rental){
        return this.priceStrategy.getPrice(rental);
    }

    @Override
    public int getFrequentRentalPoint(Rental rental) {
        return this.pointStrategy != null ? this.pointStrategy.getFrequentRentalPoint(rental) : 0;
    }
}
