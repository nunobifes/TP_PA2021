package pt.connect4.game.logic;


import pt.connect4.game.Constants;

public class Board {

    private static final int numOfRows = Constants.NUM_OF_ROWS;
    private static final int numOfColumns = Constants.NUM_OF_COLUMNS;
    private static final int inARow = Constants.IN_A_ROW;
    private final int[][] gameBoard;

    public Board() {
        gameBoard = new int[numOfRows][numOfColumns];
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void printBoard(int[][] gameBoard) {
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.println();
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                if (j != numOfColumns - 1) {
                    if (gameBoard[i][j] != 0) {
                        System.out.print("| " + gameBoard[i][j] + " ");
                    } else {
                        System.out.print("| " + "-" + " ");
                    }
                } else {
                    if (gameBoard[i][j] != 0) {
                        System.out.println("| " + gameBoard[i][j] + " |");
                    } else {
                        System.out.println("| " + "-" + " |");
                    }
                }
            }
        }
        System.out.println("\n*****************************");
    }

}
