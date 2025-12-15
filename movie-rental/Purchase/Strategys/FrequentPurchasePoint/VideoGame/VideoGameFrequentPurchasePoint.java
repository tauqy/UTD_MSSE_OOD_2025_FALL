package Purchase.Strategys.FrequentPurchasePoint.VideoGame;

import Item.VideoGame.VideoGame;
import Item.VideoGame.VideoGameType;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;
import Purchase.Strategys.PurchasePrice.Factory.VideoGamePurchaseStrategyFactory;

public class VideoGameFrequentPurchasePoint implements DiscountFrequentPurchasePoint {
    @Override
    public int getFrequentPurchasePoint(Purchase purchase) {
        VideoGame videoGame = (VideoGame) purchase.getItem();
        if(videoGame.getType() == VideoGameType.ACTION){
            return 1;
        }
        else if(videoGame.getType() == VideoGameType.RACING){
            return 2;
        }
        else if(videoGame.getType() == VideoGameType.ARCADE){
            return 3;
        }
        throw new IllegalArgumentException("Unknown Video game type");
    }
}
