package pt.connect4.game.logic.states;

import pt.connect4.game.Situation;
import pt.connect4.game.logic.data.AIPlayer;
import pt.connect4.game.logic.data.GameData;
import pt.connect4.game.logic.data.HumanPlayer;
import pt.connect4.game.logic.data.Player;
import pt.connect4.utils.XORShiftRandom;

import java.util.Random;

public class Settings extends StateAdapter{
    Random rand = new Random();

    public Settings(GameData gameData) {
        super(gameData);
    }

    @Override
    public Situation getCurrentSituation() {
        return Situation.SETTINGS;
    }

   public IStates start(int option, String name1, String name2){
        GameData gd = getGameData();

        if (option == 1) { startPVP(gd, name1, name2); gd.addMsgLog("Started PVP match");}
        if (option == 2) { startPVE(gd, name1, name2); gd.addMsgLog("Started PVE match");}
        if (option == 3) { startEVE(gd, name1, name2); gd.addMsgLog("Started EVE match");}

        return new Play(gd);
   }

   private void startPVP(GameData gd, String name1, String name2){
        Player p1 = new HumanPlayer(name1);
        gd.addMsgLog("Player " + name1 + " created");
        Player p2 = new HumanPlayer(name2);
        gd.addMsgLog("Player " + name2 + " created");
        addPlayers(gd, p1, p2);
   }

   private void startPVE(GameData gd, String name1, String name2){
       Player p1 = new HumanPlayer(name1);
       gd.addMsgLog("Player " + name1 + " created");
       Player p2 = new AIPlayer(name2);
       gd.addMsgLog("Player " + name2 + " created");
       addPlayers(gd, p1, p2);
   }

   private void startEVE(GameData gd, String name1, String name2){
       Player p1 = new AIPlayer(name1);
       gd.addMsgLog("Player " + name1 + " created");
       Player p2 = new AIPlayer(name2);
       gd.addMsgLog("Player " + name2 + " created");
       addPlayers(gd, p1, p2);
   }

   private void addPlayers(GameData gd, Player p1, Player p2){
        XORShiftRandom xsr = new XORShiftRandom(2);
       if(xsr.nextInt() < 1) {
           gd.addMsgLog("Player " + p1.getName() + " is the first to play!");
           gd.addPlayer(p1);
           gd.addPlayer(p2);
           gd.setCurrentPlayer(p1);
       } else {
           gd.addMsgLog("Player " + p2.getName() + " is the first to play!");
           gd.addPlayer(p2);
           gd.addPlayer(p1);
           gd.setCurrentPlayer(p2);
       }
   }
}
