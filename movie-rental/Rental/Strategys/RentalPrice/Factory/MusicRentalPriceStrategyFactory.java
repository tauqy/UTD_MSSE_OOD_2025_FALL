package Rental.Strategys.RentalPrice.Factory;

import Item.Item;
import Item.Music.Music;
import Item.Music.MusicType;
import Rental.DiscountRental;
import Rental.Rental;
import Rental.Strategys.RentalPrice.Music.CountryJazzRentalPriceStrategy;
import Rental.Strategys.RentalPrice.Music.HipHopPopRentalPriceStrategy;

public class MusicRentalPriceStrategyFactory {
    public DiscountRental getStrategy(Rental rental){
        Item item = rental.getItem();
        Music  music = (Music) item;
        if(music.getMusicType() == MusicType.COUNTRY || music.getMusicType() == MusicType.JAZZ){
            return new CountryJazzRentalPriceStrategy();
        }
        else if(music.getMusicType() == MusicType.HIPHOP || music.getMusicType() == MusicType.POP){
            return new HipHopPopRentalPriceStrategy();
        }
        throw new IllegalArgumentException("Unknown music type.");
    }
}
