package Item.GamingConsole;

import Item.Item;

public class GameConsole extends Item {
    private GameConsoleType gameConsoleType;

    public GameConsole(String title, GameConsoleType gameConsoleType){
        this.title = title;
        this.gameConsoleType = gameConsoleType;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public GameConsoleType getType(){
        return this.gameConsoleType;
    }
}
