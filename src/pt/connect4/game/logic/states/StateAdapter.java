package pt.connect4.game.logic.states;

import pt.connect4.game.logic.data.GameData;
import pt.connect4.game.logic.data.Player;

public abstract class StateAdapter implements IStates{

    private GameData g;

    public StateAdapter(GameData gameData)
    {
        this.g = gameData;
    }

    public GameData getGameData()
    {
        return g;
    }

    public void setGameData(GameData gameData)
    {
        this.g = gameData;
    }
    public IStates start(int option, String name1, String name2) { return this;}
    public IStates restartGame() {return this;};
    public IStates playPiece(Player player, int col, boolean special) {
        return this;
    }
}
