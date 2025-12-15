package Item.Movie;

import Item.Item;

public class Movie extends Item {
    public MovieType movieType;
    
    public Movie(String title, MovieType type) {
        this.title = title;
        movieType = type;
    }
    
    public MovieType getMovieType() {
        return movieType;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}