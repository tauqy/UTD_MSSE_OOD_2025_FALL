package Purchase.Strategies.PurchasePrice.Factory;

import Item.Book.Book;
import Item.Book.BookType;
import Item.Item;
import Purchase.DiscountPurchase;
import Purchase.Purchase;
import Purchase.Strategies.PurchasePrice.BookPurchase.ActionBookPurchase;
import Purchase.Strategies.PurchasePrice.BookPurchase.HorrorBookPurchase;

public class BookPurchaseStrategyFactory {
    public DiscountPurchase getStrategy(Purchase purchase){
        Item item = purchase.getItem();
        Book book = (Book)item;
        if(book.getBookType() == BookType.ACTION){
            return new ActionBookPurchase();
        }
        else if(book.getBookType() == BookType.HORROR){
            return new HorrorBookPurchase();
        }
        throw new IllegalArgumentException("Unknown Book Type.");
    }
}
