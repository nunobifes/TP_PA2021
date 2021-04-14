package pt.connect4;

import pt.connect4.game.logic.Board;

public class Main {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        board.printBoard(board.getGameBoard());
    }
}
