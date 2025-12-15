package Rental.Strategies.RentalPrice.Factory;

import Item.Book.Book;
import Item.Item;
import Item.Movie.Movie;
import Item.Music.Music;
import Rental.DiscountRental;
import Rental.Rental;

public class ItemRentalPriceStrategyFactory {
    public DiscountRental getRentalPriceStrategy(Rental rental){
        Item item = rental.getItem();
        if(item instanceof Movie){
            return new MovieRentalPriceStrategyFactory().getStrategy(rental);
        }
        if(item instanceof Book){
            return new BookRentalPriceStrategyFactory().getStrategy(rental);
        }
        if(item instanceof Music){
            return new MusicRentalPriceStrategyFactory().getStrategy(rental);
        }
        throw new IllegalArgumentException("Unknow Item Type");
    }
}
