package Rental.Strategys.RentalPrice.Factory;

import Item.Book.Book;
import Item.Book.BookType;
import Item.Item;
import Rental.DiscountRental;
import Rental.Rental;
import Rental.Strategys.RentalPrice.BookRental.ActionBookRentalPrice;
import Rental.Strategys.RentalPrice.BookRental.HorrorBookRentalPrice;

public class BookRentalPriceStrategyFactory {
    public DiscountRental getStrategy(Rental rental){
        Item item = rental.getItem();
        Book book = (Book) item;
        if(book.getBookType() == BookType.ACTION){
            return new ActionBookRentalPrice();
        }
        else if(book.getBookType() == BookType.HORROR){
            return new HorrorBookRentalPrice();
        }
        throw new IllegalArgumentException("Unknown Book type.");
    }
}
