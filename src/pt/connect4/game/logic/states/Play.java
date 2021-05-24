package pt.connect4.game.logic.states;

import pt.connect4.game.Situation;
import pt.connect4.game.logic.data.GameData;
import pt.connect4.game.logic.data.Player;
import pt.connect4.utils.XORShiftRandom;

public class Play extends StateAdapter{
    public Play(GameData gameData) {
        super(gameData);
    }

    @Override
    public Situation getCurrentSituation() {
        return Situation.PLAY_PIECE;
    }

    @Override
    public IStates playPiece(Player player, int col, boolean special) {
        GameData gd = getGameData();

        gd.newPiece(player, col, special);
        if(!special)
            gd.addMsgLog("Player " + player.getName() + " played a piece on column: " + col);
        else
            gd.addMsgLog("Player " + player.getName() + " played a special piece on column: " + col);

        // checks if game is over
        if(gd.checkGameOver())
            return new GameOver(gd);

        gd.incTurn();
        gd.incPlayer();

        // not implemented
        /*if(gd.itsMiniGameTime()){
            return new MiniGame(gd);
        }*/

        return new Play(gd);
    }
}
