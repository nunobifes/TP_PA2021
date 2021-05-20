package pt.connect4.game.logic.data;

public class HumanPlayer extends Player {

    private final int nSpecialPiece;
    private final int nCredits;

    public HumanPlayer(String name) {
        this.name = name;
        this.nSpecialPiece = 0;
        this.nCredits = 5;

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\tSpecial Pieces: " + nSpecialPiece + "\tCredits: " + nCredits);
        return sb.toString();
    }
}
