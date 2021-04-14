package pt.connect4.game.logic.states;

import pt.connect4.game.logic.data.GameData;

public abstract class MiniGame extends StateAdapter{
    public MiniGame(GameData gameData) {
        super(gameData);
    }
}
