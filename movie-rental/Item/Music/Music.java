package Item.Music;

import Item.Item;

public class Music extends Item {
    private MusicType musicType;

    public Music(String title, MusicType musicType){
        this.musicType = musicType;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public MusicType getMusicType(){
        return this.musicType;
    }
}
