package Purchase.Coupons;

import Item.Book.Book;
import Item.Item;
import Item.Movie.Movie;
import Item.VideoGame.VideoGame;
import Purchase.Purchase;

public class FreeMovieRedemptionPurchaseCoupon extends PurchaseCouponDecorator{
    public static final int REDEMPTION_POINT_COST = 10;
    private final boolean isRedeemable;

    public FreeMovieRedemptionPurchaseCoupon(Purchase purchase, double customerPointBalance) {
        super(purchase);
        this.isRedeemable = customerPointBalance >= REDEMPTION_POINT_COST;
    }

    @Override
    public double getPrice(Purchase purchase) {
        if(purchase.getItem() instanceof Movie && this.isRedeemable) {
            return 0.0;
        }
        return super.getPrice(purchase);
    }

    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        if(purchase.getItem() instanceof Movie && this.isRedeemable) {
            return -REDEMPTION_POINT_COST;
        }
        return super.getFrequentPurchasePoint(purchase);
    }
}
