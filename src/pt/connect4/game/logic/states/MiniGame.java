package pt.connect4.game.logic.states;

import pt.connect4.game.Situation;
import pt.connect4.game.logic.data.GameData;

public class MiniGame extends StateAdapter{
    public MiniGame(GameData gameData) {
        super(gameData);
    }

    @Override
    public Situation getCurrentSituation() {
        return null;
    }
}
