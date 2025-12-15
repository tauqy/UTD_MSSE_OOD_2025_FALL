package Purchase.Strategies.PurchasePrice.PopcornPurchase;

import Item.Popcorn.Popcorn;
import Item.Popcorn.PopcornSize;
import Purchase.DiscountPurchase;
import Purchase.Purchase;

public class PopcornSizePurchaseStrategy implements DiscountPurchase {
    @Override
    public double getPrice(Purchase purchase) {
        Popcorn popcorn = (Popcorn) purchase.getItem();
        if(popcorn.popcornSize == PopcornSize.SMALL){
            return 1;
        }
        else if(popcorn.popcornSize == PopcornSize.MEDIUM){
            return 2;
        } else if (popcorn.popcornSize == PopcornSize.LARGE) {
            return 2.5;
        }
        else if(popcorn.popcornSize == PopcornSize.XLARGE){
            return 3;
        }
        throw new IllegalArgumentException("Unknow Popcorn size.");
    }
}
