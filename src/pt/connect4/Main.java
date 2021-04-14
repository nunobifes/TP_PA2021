package pt.connect4;

import pt.connect4.game.logic.Game;
import pt.connect4.ui.text.TextUserInterface;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        TextUserInterface ui = new TextUserInterface(game);
        ui.printBoard();
    }
}
