package pt.connect4.game.logic.states;

import pt.connect4.game.Situation;
import pt.connect4.game.logic.data.GameData;

public class Settings extends StateAdapter{
    public Settings(GameData gameData) {
        super(gameData);
    }

    @Override
    public Situation getCurrentSituation() {
        return Situation.SETTINGS;
    }
}
