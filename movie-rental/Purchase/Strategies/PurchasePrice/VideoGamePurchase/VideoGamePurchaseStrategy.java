package Purchase.Strategies.PurchasePrice.VideoGamePurchase;

import Item.VideoGame.VideoGame;
import Item.VideoGame.VideoGameType;
import Purchase.DiscountPurchase;
import Purchase.Purchase;

public class VideoGamePurchaseStrategy implements DiscountPurchase {
    @Override
    public double getPrice(Purchase purchase) {
        VideoGame videoGame = (VideoGame) purchase.getItem();
        if(videoGame.getType() == VideoGameType.ACTION){
            return 15;
        }
        else if(videoGame.getType() == VideoGameType.ARCADE){
            return 10;
        }
        else if(videoGame.getType() == VideoGameType.RACING){
            return 25;
        }
        throw new IllegalArgumentException("Unknown Video Game Type");
    }
}
