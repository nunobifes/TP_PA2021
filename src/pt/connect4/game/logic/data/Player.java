package pt.connect4.game.logic.data;

import java.util.ArrayList;

public class Player {

    private String name;
    private int nSpecialPiece;
    private int nCredits;

    public Player(String name) {
        this.name = name;
        nSpecialPiece = 0;
        nCredits = 5;
    }
}
