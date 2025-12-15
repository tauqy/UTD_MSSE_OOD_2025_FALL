package Purchase.Coupons;

import Item.Item;
import Item.Movie.Movie;
import Purchase.Purchase;

public class FreeMoviePurchaseSeniorCoupon extends PurchaseCouponDecorator {

    private final int customerAge;
    private static final int SENIOR_AGE_THRESHOLD = 65;

    public FreeMoviePurchaseSeniorCoupon(Purchase purchase, int customerAge) {
        super(purchase);
        this.customerAge = customerAge;
    }

    @Override
    public double getPrice(Purchase purchase) {
        Item item = purchase.getItem();

        // Condition 1: Must be a Movie
        // Condition 2: Customer must be a Senior Citizen (65+)
        if (item instanceof Movie && this.customerAge >= SENIOR_AGE_THRESHOLD) {
            return 0.0;
        }

        return super.getPrice(purchase);
    }
}