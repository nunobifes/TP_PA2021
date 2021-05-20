package pt.connect4.game.logic.data;

import pt.connect4.utils.CircularIterator;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    private List<String> msgLog;
    private Board board;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CircularIterator<Player> ciPlayer;
    private int turn;

    public GameData() {
        msgLog = new ArrayList<>();
        players = new ArrayList<>();
        board = new Board();
        initialize();
        turn = 1;
        ciPlayer = new CircularIterator<>(players);
    }

    public void initialize(){
        clearMsgLog();
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

}
