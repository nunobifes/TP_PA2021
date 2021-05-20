package pt.connect4;

import pt.connect4.game.logic.Game;
import pt.connect4.game.logic.data.AIPlayer;
import pt.connect4.game.logic.data.HumanPlayer;
import pt.connect4.game.logic.data.Player;
import pt.connect4.ui.text.TextUserInterface;
import pt.connect4.utils.CircularIterator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        TextUserInterface ui = new TextUserInterface(game);
        ui.run();
    }
}
