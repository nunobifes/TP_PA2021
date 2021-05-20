package pt.connect4.game.logic.states;

import pt.connect4.game.Situation;
import pt.connect4.game.logic.data.GameData;
import pt.connect4.game.logic.data.Player;

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
        gd.incTurn();
        gd.incPlayer();
        return new Play(gd);
    }
}
