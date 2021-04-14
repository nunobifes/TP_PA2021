package pt.connect4.game.logic.data;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    private List<String> msgLog;
    private Board board;
    private Player player1;
    private Player player2;

    public GameData() {
        msgLog = new ArrayList<>();
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

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }
}
