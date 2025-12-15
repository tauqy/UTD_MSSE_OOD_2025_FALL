package Item.VideoGame;

import Item.Item;

public class VideoGame extends Item {
    private VideoGameType type;

    public VideoGame(String title, VideoGameType type){
        this.title = title;
        this.type = type;
    }
    @Override
    public String getTitle() {
        return this.title;
    }

    public VideoGameType getType(){
        return this.type;
    }
}
