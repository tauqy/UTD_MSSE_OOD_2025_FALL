package Rental.Strategies.FrequentRentalPoints.Factory;

import Item.Music.Music;
import Item.Music.MusicType;
import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;
import Rental.Strategies.FrequentRentalPoints.Music.CountryPopFrequentRentalPointStrategy;
import Rental.Strategies.FrequentRentalPoints.Music.HiphopJazzFrequentRentalPointStrategy;

public class MusicFrequentRentalPointFactory {
    public DiscountFrequentRentalPoint getStrategy(Rental rental) {
        Music music = (Music) rental.getItem();
        if(music.getMusicType() == MusicType.COUNTRY || music.getMusicType() == MusicType.POP){
            return new CountryPopFrequentRentalPointStrategy();
        }
        else if(music.getMusicType() == MusicType.HIPHOP  || music.getMusicType() == MusicType.JAZZ){
            return new HiphopJazzFrequentRentalPointStrategy();
        }
        throw new IllegalArgumentException("Unknow Music Type");
    }
}
