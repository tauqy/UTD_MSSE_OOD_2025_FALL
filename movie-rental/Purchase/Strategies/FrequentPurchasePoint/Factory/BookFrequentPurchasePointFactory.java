package Purchase.Strategies.FrequentPurchasePoint.Factory;

import Item.Book.Book;
import Item.Book.BookType;
import Item.Item;
import Purchase.DiscountFrequentPurchasePoint;
import Purchase.Strategies.FrequentPurchasePoint.Book.ActionBookFrequentPurchasePoint;
import Purchase.Strategies.FrequentPurchasePoint.Book.HorrorBookFrequentPurchasePoint;

public class BookFrequentPurchasePointFactory {
    public DiscountFrequentPurchasePoint getStrategy(Item item){
        Book book = (Book) item;
        if(book.getBookType() == BookType.ACTION){
            return new ActionBookFrequentPurchasePoint();
        }
        else if(book.getBookType() == BookType.HORROR){
            return new HorrorBookFrequentPurchasePoint();
        }
        throw new IllegalArgumentException("Unknown Book Type");
    }
}
