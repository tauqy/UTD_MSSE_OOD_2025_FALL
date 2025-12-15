package Purchase.Strategies.FrequentPurchasePoint.Factory;

import Item.Item;
import Item.VideoGame.VideoGame;
import Item.VideoGame.VideoGameType;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Purchase;
import Purchase.Strategies.FrequentPurchasePoint.VideoGame.VideoGameFrequentPurchasePoint;

public class VideoGameFrequentPurchasePointFactory {
    public DiscountFrequentPurchasePoint getStrategy(Purchase purchase){
        Item item = purchase.getItem();
        VideoGame videoGame = (VideoGame) item;
        if(videoGame.getType() == VideoGameType.ACTION || videoGame.getType() == VideoGameType.ARCADE || videoGame.getType() == VideoGameType.RACING)
            return new VideoGameFrequentPurchasePoint();
        throw new IllegalArgumentException("Unknown Video game type.");
    }
}
