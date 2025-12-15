package Purchase.Strategys.FrequentPurchasePoint.Factory;

import Item.Item;
import Item.VideoGame.VideoGame;
import Item.VideoGame.VideoGameType;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Strategys.FrequentPurchasePoint.VideoGame.VideoGameFrequentPurchasePoint;

public class VideoGameFrequentPurchasePointFactory {
    public DiscountFrequentPurchasePoint getStrategy(Item item){
        VideoGame videoGame = (VideoGame) item;
        if(videoGame.getType() == VideoGameType.ACTION || videoGame.getType() == VideoGameType.ARCADE || videoGame.getType() == VideoGameType.RACING)
            return new VideoGameFrequentPurchasePoint();
        throw new IllegalArgumentException("Unknown Video game type.");
    }
}
