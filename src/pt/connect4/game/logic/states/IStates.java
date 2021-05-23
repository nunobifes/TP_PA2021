package pt.connect4.game.logic.states;

import pt.connect4.game.Situation;
import pt.connect4.game.logic.data.Player;

public interface IStates {


    Situation getCurrentSituation();
    public IStates start(int option, String name1, String name2);
    public IStates playPiece(Player player, int col, boolean special);
    public IStates restartGame();
}
