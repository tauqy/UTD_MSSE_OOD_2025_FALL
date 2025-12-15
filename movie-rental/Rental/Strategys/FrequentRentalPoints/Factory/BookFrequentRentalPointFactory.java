package Rental.Strategys.FrequentRentalPoints.Factory;

import Item.Book.Book;
import Item.Book.BookType;
import Rental.DiscountFrequentRentalPoint;
import Rental.Rental;
import Rental.Strategys.FrequentRentalPoints.Book.ActionBookFrequentRentalPoint;
import Rental.Strategys.FrequentRentalPoints.Book.HorrorBookFrequentalRentalPoint;

public class BookFrequentRentalPointFactory {
    public DiscountFrequentRentalPoint getStrategy(Rental rental) {
        Book book = (Book) rental.getItem();
        BookType bookType = book.getBookType();
        if(bookType == BookType.HORROR){
            return new HorrorBookFrequentalRentalPoint();
        }
        else if(bookType == BookType.ACTION){
            return new ActionBookFrequentRentalPoint();
        }
        throw new IllegalArgumentException("Unknown Book Type");
    }
}
