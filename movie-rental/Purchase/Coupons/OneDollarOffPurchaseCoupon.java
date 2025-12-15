package Purchase.Coupons;

import Item.Book.Book;
import Item.GamingConsole.GameConsole;
import Item.Item;
import Item.Movie.Movie;
import Item.VideoGame.VideoGame;
import Purchase.Purchase;

public class OneDollarOffPurchaseCoupon extends PurchaseCouponDecorator {

    public OneDollarOffPurchaseCoupon(Purchase purchase){
        super(purchase);
    }
    @Override
    public double getPrice(Purchase purchase) {
        Item item = purchase.getItem();
        double basePrice = super.getPrice(purchase);
        if(item instanceof Movie || item instanceof Book || item instanceof VideoGame || item instanceof GameConsole){
            return basePrice - 1.0;
        }
        return basePrice;
    }
}
