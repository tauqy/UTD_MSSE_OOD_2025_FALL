package Rental.Coupons;

import Item.Item;
import Item.Movie.Movie;
import Item.Movie.MovieType;
import Rental.Rental;

public class OneDollarOffChildrenMovieCoupon extends RentalCouponDecorator {

    private final int customerAge;

    public OneDollarOffChildrenMovieCoupon(Rental rental, int customerAge) {
        super(rental);
        this.customerAge = customerAge;
    }

    @Override
    public double getPrice(Rental rental) {
        double basePrice = super.getPrice(rental);
        Item item = rental.getItem();

        // Check if item is a Movie
        if (item instanceof Movie) {
            Movie movie = (Movie) item;

            // Condition 1: Must be Children's Movie
            boolean isChildrenMovie = movie.getMovieType() == MovieType.CHILDREN;

            // Condition 2: Age must be 18-22
            boolean isEligibleAge = this.customerAge >= 18 && this.customerAge <= 22;

            if (isChildrenMovie && isEligibleAge) {
                // Ensure price doesn't go negative
                return Math.max(0, basePrice - 1.0);
            }
        }

        return basePrice;
    }
}