package pt.connect4.ui.text;

import pt.connect4.game.logic.Game;

public class TextUserInterface {

    private Game g;

    public TextUserInterface(Game g){
        this.g = g;
    }

    public void printBoard(){
        g.getBoard().printBoard();
    }
}
