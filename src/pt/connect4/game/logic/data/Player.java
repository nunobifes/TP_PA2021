package pt.connect4.game.logic.data;

public abstract class Player {

    String name;

    public Player() {
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() { return name.substring(0,1).toUpperCase();}

    @Override
    public String toString() {
        return name;
    }
}
