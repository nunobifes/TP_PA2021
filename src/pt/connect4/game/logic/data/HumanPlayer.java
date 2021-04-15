package pt.connect4.game.logic.data;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        this.name = name;
        nSpecialPiece = 0;
        nCredits = 5;
    }
}
