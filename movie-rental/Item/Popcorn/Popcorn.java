package Item.Popcorn;

import Item.Item;

public class Popcorn extends Item {

    public PopcornSize popcornSize;

    public Popcorn(String title, PopcornSize type){
        this.title = title;
        this.popcornSize = type;
    }

    public PopcornSize getPopcornSize(){
        return this.popcornSize;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
