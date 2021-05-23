package pt.connect4.game.logic.data;


import pt.connect4.game.Constants;

import java.util.ArrayList;

public class Board {

    private static final int numOfRows = Constants.NUM_OF_ROWS;
    private static final int numOfColumns = Constants.NUM_OF_COLUMNS;
    private static final int inARow = Constants.IN_A_ROW;

    private final ArrayList<ArrayList<Piece>> gameBoard;
    private ArrayList<Piece> lastMoves;

    public Board() {
        gameBoard = initializeGameBoard();
        lastMoves = new ArrayList<>();
    }

    private ArrayList<ArrayList<Piece>> initializeGameBoard(){
        ArrayList<ArrayList<Piece>> aux = new ArrayList<>();
        for (int i = 0; i < numOfRows; i++) {
            ArrayList<Piece> row = new ArrayList<>();
            for (int j = 0; j < numOfColumns; j++) {
                row.add(null);
            }
            aux.add(row);
        }
        return aux;
    }

    public ArrayList<ArrayList<Piece>> getGameBoard() {
        return gameBoard;
    }

    public void removePiece(Pos pos){
        gameBoard.get(pos.getRow()).set(pos.getColumn(), null);
    }

    public void removeColumn(int col){
        for (int i = 0; i < numOfRows; i++) {
            removePiece(new Pos(i, col));
        }
    }

    public void newPiece(Player player, int col, boolean special){
        int i = numOfRows-1;
        while (i >= 0){
            ArrayList<Piece> row = gameBoard.get(i);
            if(row.get(col) == null){
                Piece piece = new Piece(new Pos(i, col), player, special);
                row.set(col, piece);
                lastMoves.add(piece);
                if(special)
                    removeColumn(col);
                break;
            }
            i--;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t\t\t\t| 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n");
        sb.append("\n");
        for (int i = 0; i < numOfRows; i++) {
            sb.append("\t\t\t\t\t");
            ArrayList<Piece> row = gameBoard.get(i);
            for (int j = 0; j < numOfColumns; j++) {
                Piece piece = row.get(j);
                if (j != numOfColumns - 1) {
                    if (piece != null) {
                        sb.append("| " + piece.getPlayer().getIdentifier() + " ");
                    } else {
                        sb.append("| " + "-" + " ");
                    }
                } else {
                    if (piece != null) {
                        sb.append("| " + piece.getPlayer().getIdentifier() + " |\n");
                    } else {
                        sb.append("| " + "-" + " |\n");
                    }
                }
            }
        }
        sb.append("\n\t\t\t\t\t*****************************");
        return sb.toString();
    }

    public boolean fullColumn(int col) {
        if(gameBoard.get(0).get(col) != null)
            return true;
        return false;
    }

    private boolean canMove(int row, int col) {
        if ((row <= -1) || (col <= -1) || (row > numOfRows-1) || (col > numOfColumns-1)) {
            return false;
        }
        return true;
    }

    public int countInARow(Player player){
        int times = 0;

        // checks inARow consecutive pieces of the same player horizontally
        for(int i = 0; i < numOfRows; i++){
            for (int j = 0; j < numOfColumns; j++) {
                if(canMove(i, j+inARow-1)) {
                    int k = 0;
                    while (k < inARow && gameBoard.get(i).get(j + k) != null && gameBoard.get(i).get(j + k).getPlayer().equals(player))
                        k++;
                    if (k == inARow) times++;
                }
            }
        }

        // checks inARow consecutive pieces of the same player vertically
        for(int i = 0; i < numOfRows; i++){
            for (int j = 0; j < numOfColumns; j++) {
                if(canMove(i-inARow+1, j)) {
                    int k = 0;
                    while (k < inARow && gameBoard.get(i-k).get(j) != null && gameBoard.get(i-k).get(j).getPlayer().equals(player))
                        k++;
                    if (k == inARow) times++;
                }
            }
        }

        // checks inARow consecutive pieces of the same player in descending diagonal
        for(int i = 0; i < numOfRows; i++){
            for (int j = 0; j < numOfColumns; j++) {
                if(canMove(i+inARow-1, j+inARow-1)) {
                    int k = 0;
                    while (k < inARow && gameBoard.get(i+k).get(j+k) != null && gameBoard.get(i+k).get(j+k).getPlayer().equals(player))
                        k++;
                    if (k == inARow) times++;
                }
            }
        }

        // checks inARow consecutive pieces of the same player in ascending diagonal
        for(int i = 0; i < numOfRows; i++){
            for (int j = 0; j < numOfColumns; j++) {
                if(canMove(i-inARow+1, j+inARow-1)) {
                    int k = 0;
                    while (k < inARow && gameBoard.get(i-k).get(j+k) != null && gameBoard.get(i-k).get(j+k).getPlayer().equals(player))
                        k++;
                    if (k == inARow) times++;
                }
            }
        }
        return times;
    }


    public boolean boardIsFull(){
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                if(gameBoard.get(i).get(j) == null)
                    return false;
            }
        }
        return true;
    }

}
