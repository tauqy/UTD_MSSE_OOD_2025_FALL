package Purchase.Coupons;

import Item.Book.Book;
import Item.Item;
import Item.Movie.Movie;
import Item.Popcorn.Popcorn;
import Item.VideoGame.VideoGame;
import Purchase.Purchase;

public class FiftyPercentOffPurchaseCoupon extends PurchaseCouponDecorator{

    public FiftyPercentOffPurchaseCoupon(Purchase purchase) {
        super(purchase);
    }

    @Override
    public double getPrice(Purchase purchase) {
        Item item = purchase.getItem();
        if(item instanceof Movie || item instanceof Book || item instanceof VideoGame || item instanceof Popcorn){
            return super.getPrice(purchase) * 0.50;
        }
        return purchase.getPrice(purchase);
    }
}
