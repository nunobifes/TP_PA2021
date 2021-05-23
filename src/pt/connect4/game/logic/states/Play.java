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

        if(gd.itsMiniGameTime()){
            XORShiftRandom xsr = new XORShiftRandom(2);
            if(xsr.nextInt() > 1)
                return new MathGame(gd);
            else
                return new WordGame(gd);
        }


        gd.newPiece(player, col, special);

        // checks if game is over
        if(gd.checkGameOver())
            return new GameOver(gd);

        gd.incTurn();
        gd.incPlayer();

        return new Play(gd);
    }
}
