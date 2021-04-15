package pt.connect4.game.logic.data;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    private List<String> msgLog;
    private Board board;
    private Player currentPlayer;
    private ArrayList<Player> players;

    public GameData() {
        msgLog = new ArrayList<>();
        players = new ArrayList<>();
        board = new Board();
        initialize();
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

    public Board getBoard() {
        return board;
    }
}
