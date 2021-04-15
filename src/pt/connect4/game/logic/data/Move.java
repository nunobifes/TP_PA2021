package pt.connect4.game.logic.data;

public class Move {

    private int row;
    private int column;
    private int value;

    public Move(int value) {
        this.value = value;
    }

    public Move(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Move() {
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
