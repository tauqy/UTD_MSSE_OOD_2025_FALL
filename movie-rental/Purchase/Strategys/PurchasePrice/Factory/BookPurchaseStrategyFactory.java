package Purchase.Strategys.PurchasePrice.Factory;

import Item.Book.Book;
import Item.Book.BookType;
import Item.Item;
import Purchase.DiscountPurchase;
import Purchase.Strategys.PurchasePrice.BookPurchase.ActionBookPurchase;
import Purchase.Strategys.PurchasePrice.BookPurchase.HorrorBookPurchase;

public class BookPurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Item item){
        Book book = (Book)item;
        if(book.getBookType() == BookType.ACTION){
            return new ActionBookPurchase();
        }
        else if(book.getBookType() == BookType.HORROR){
            return new HorrorBookPurchase();
        }
        throw new IllegalArgumentException("Unknow Book Type.");
    }
}
