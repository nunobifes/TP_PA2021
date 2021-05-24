package pt.connect4.game.logic.data;

import pt.connect4.game.Constants;
import pt.connect4.utils.CircularIterator;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    private List<String> msgLog;
    private Board board;
    private Player currentPlayer;
    private Player winner;
    private ArrayList<Player> players;
    private CircularIterator<Player> ciPlayer;
    private int turn;

    public GameData() {
        msgLog = new ArrayList<>();
        players = new ArrayList<>();
        initialize();
    }

    public void initialize(){
        clearMsgLog();
        players.clear();
        board = new Board();
        turn = 1;
        ciPlayer = new CircularIterator<>(players);
    }

    public void clearMsgLog(){
        msgLog.clear();
    }

    public void addMsgLog(String msg){
        msgLog.add(msg);
    }

    public List<String> getMsgLog(){
        return msgLog;
    }

    public Player getCurrentPlayer() { return currentPlayer; }

    /*public Board getBoard() {
        return board;
    }*/

    public void incTurn(){
        turn++;
    }

    public void newPiece(Player player, int col, boolean special){
        board.newPiece(player, col, special);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void incPlayer(){
        setCurrentPlayer(ciPlayer.next());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("\tCurrent Player: " + currentPlayer + "\tTurn: " + turn + "\n\n");
        sb.append(board);
        return sb.toString();
    }

    public boolean fullColumn(int col) {
        return board.fullColumn(col);
    }

    private boolean checkWinState(){
        int timesInARow = board.countInARow(currentPlayer);
        if(timesInARow > 0) {
            winner = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkGameOver(){
        if(checkWinState())
            return true;

        return checkDraw();
    }

    private boolean checkDraw() {
        if(board.boardIsFull())
            return true;

        return false;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean itsMiniGameTime(){
        if(turn % 8 == 0 && currentPlayer instanceof HumanPlayer)
            return true;

        return false;
    }

}
