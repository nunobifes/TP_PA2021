package pt.connect4.game.logic.data;

public class Piece {

    private Pos pos;
    private Player player;
    private boolean special;


    public Piece(Pos pos, Player player, boolean special) {
        this.pos = pos;
        this.player = player;
        this.special = special;
    }

    public Piece(Pos pos, Player player) {
        this.pos = pos;
        this.player = player;
    }

    public Pos getPos() {
        return pos;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isSpecial() { return special; }
}
