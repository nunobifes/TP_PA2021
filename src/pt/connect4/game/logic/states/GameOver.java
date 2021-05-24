package pt.connect4.game.logic.states;

import pt.connect4.game.Situation;
import pt.connect4.game.logic.data.GameData;

public class GameOver extends StateAdapter{
    public GameOver(GameData gameData) {
        super(gameData);
    }

    @Override
    public Situation getCurrentSituation() {
        return Situation.GAME_OVER;
    }

    public IStates restartGame(){
        GameData gd = getGameData();

        gd.initialize();

        return new Settings(gd);
    }

}
