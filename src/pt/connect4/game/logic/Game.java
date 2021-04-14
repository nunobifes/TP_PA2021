package pt.connect4.game.logic;

import pt.connect4.game.logic.data.GameData;
import pt.connect4.game.logic.states.IStates;
import pt.connect4.game.logic.states.Settings;

public class Game {

    private GameData gameData;
    private IStates state;


    public Game() {
        gameData = new GameData();
        state = new Settings(gameData);
    }
}
