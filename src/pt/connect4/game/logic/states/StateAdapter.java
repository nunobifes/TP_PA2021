package pt.connect4.game.logic.states;

import pt.connect4.game.logic.data.GameData;

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

}
