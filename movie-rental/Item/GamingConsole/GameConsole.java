package Item.GamingConsole;

import Item.Item;

public class GameConsole extends Item {
    private GameConsoleType type;

    public GameConsole(String title, GameConsoleType gameConsoleType){
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public GameConsoleType getType(){
        return this.type;
    }
}
