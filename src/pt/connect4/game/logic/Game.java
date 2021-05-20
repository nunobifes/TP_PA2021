package pt.connect4.game.logic;

import pt.connect4.game.logic.data.Board;
import pt.connect4.game.logic.data.GameData;
import pt.connect4.game.logic.states.*;

import java.util.List;

public class Game {

    private GameData gameData;
    private IStates state;


    public Game() {
        gameData = new GameData();
        state = new Settings(gameData);
    }

    public List<String> getMsgLog()
    {
        return gameData.getMsgLog();
    }

    public void clearMsgLog()
    {
        gameData.clearMsgLog();
    }

    public boolean isAwaitingSettings(){
        return state instanceof Settings;
    }
    public boolean isAwaitingPlay(){
        return state instanceof Play;
    }
    public boolean isAwaitingMiniGame(){
        return state instanceof MiniGame;
    }
    public boolean isAwaitingGameOver(){
        return state instanceof GameOver;
    }

    public void start(int option, String name1, String name2){
        state = state.start(option, name1, name2);
    }

    //public Board getBoard(){
        //return gameData.getBoard();
    //}

    @Override
    public String toString() {
        return gameData.toString();
    }

    public void exit() {
        System.exit(0);
    }

    public void newPiece(int op, int col) {
        if(op == 1)
            state = state.playPiece(gameData.getCurrentPlayer(), col, false);
        else{
            state = state.playPiece(gameData.getCurrentPlayer(), col, true);
        }
    }

    public boolean fullColumn(int col) {
        return gameData.fullColumn(col);
    }
}
