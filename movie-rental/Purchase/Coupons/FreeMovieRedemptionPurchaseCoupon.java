package Purchase.Coupons;

import Item.Book.Book;
import Item.Item;
import Item.Movie.Movie;
import Item.VideoGame.VideoGame;
import Purchase.Purchase;

public class FreeMovieRedemptionPurchaseCoupon extends PurchaseCouponDecorator{
    public FreeMovieRedemptionPurchaseCoupon(Purchase purchase){
        super(purchase.getDiscountPurchase());
        purchase.setDiscountPurchase(this);
    }

    @Override
    public double getPrice(Purchase purchase) {
        Item item = purchase.getItem();
        if(item instanceof Movie || item instanceof Book || item instanceof VideoGame)
        {
            return 0;
        }
        return super.getPrice(purchase);
    }
}
