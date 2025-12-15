package Item.Book;

import Item.Item;

public class Book extends Item {

    private BookType bookType;

    public Book(String title, BookType bookType){
        this.title = title;
        this.bookType = bookType;
    }

    public BookType getBookType(){
        return bookType;
    }
    @Override
    public String getTitle() {
        return this.title;
    }
}
