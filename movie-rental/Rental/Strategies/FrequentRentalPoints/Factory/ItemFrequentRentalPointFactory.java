package Rental.Strategies.FrequentRentalPoints.Factory;

import Item.Book.Book;
import Item.Item;
import Item.Movie.Movie;
import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;

public class ItemFrequentRentalPointFactory {
    public DiscountFrequentRentalPoint getFrequentRentalPointStrategy(Rental rental){
        Item item = rental.getItem();
        if(item instanceof Movie){
            return new MovieFrequentRentalPointFactory().getStrategy(rental);
        }
        else if(item instanceof Book){
            return new BookFrequentRentalPointFactory().getStrategy(rental);
        }
        throw new IllegalArgumentException("Unknow Item type.");
    }
}
