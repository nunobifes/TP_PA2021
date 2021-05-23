package pt.connect4.ui.text;

import pt.connect4.game.logic.Game;
import pt.connect4.utils.XORShiftRandom;

import java.util.Scanner;


public class TextUserInterface {

    private Game g;
    private Scanner sc;
    int op;

    public TextUserInterface(Game g){
        this.g = g;
        sc = new Scanner(System.in);
    }

    public void printBoard(){
        //g.getBoard().printBoard();
    }

    private void printHeader(){
        System.out.println(" ▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄   ▄▄    ▄   ▄▄    ▄   ▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄    ▄   ▄▄▄ ");
        System.out.println("█       █ █       █ █  █  █ █ █  █  █ █ █       █ █       █ █       █  █ █ █   █");
        System.out.println("█       █ █   ▄   █ █   █▄█ █ █   █▄█ █ █    ▄▄▄█ █       █ █▄     ▄█  █ █▄█   █");
        System.out.println("█     ▄▄█ █  █ █  █ █       █ █       █ █   █▄▄▄▄ █     ▄▄█   █   █    █       █");
        System.out.println("█    █    █  █▄█  █ █  ▄    █ █  ▄    █ █    ▄▄▄█ █    █      █   █    █▄▄▄    █");
        System.out.println("█    █▄▄  █       █ █ █ █   █ █ █ █   █ █   █▄▄▄▄ █    █▄▄    █   █        █   █");
        System.out.println("█▄▄▄▄▄▄▄█ █▄▄▄▄▄▄▄█ █▄█  █▄▄█ █▄█  █▄▄█ █▄▄▄▄▄▄▄█ █▄▄▄▄▄▄▄█   █▄▄▄█        █▄▄▄█");
        System.out.println();

    }

    private void printSettingsMenu(){
        String player1 = "";
        String player2 = "";

        System.out.println("\n");
        System.out.println("\t\t\t\t\t\tChoose what to play: ");
        System.out.println("\t\t\t\t\t\t\t1 - PVP");
        System.out.println("\t\t\t\t\t\t\t2 - PVE");
        System.out.println("\t\t\t\t\t\t\t3 - EVE");
        System.out.println("\t\t\t\t\t\t\t4 - EXIT");
        System.out.print("\n\t\t\tOption: ");

        while (!sc.hasNextInt())
            sc.next();

        op = sc.nextInt();

        if(op == 4)
            g.exit();

        do{
            System.out.print("\nEnter Player 1 name: ");
            while (!sc.hasNext())
                sc.next();
            player1 = sc.next();
            System.out.print("Enter Player 2 name: ");
            while (!sc.hasNext())
                sc.next();
            player2 = sc.next();
        }while (player1.equals(player2));

        g.start(op, player1, player2);

    }

    private void printGameOverMenu() {
        System.out.println();
        showGame();
        System.out.println("Winner --> " + g.getWinner() + " !");
        System.out.println("Congratulations!");
        System.out.println("\n\n\t\tPress enter to continue...");
        g.restartGame();
        try{
            System.in.read();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void printMiniGameMenu() {
    }

    private void printPlayMenu() {
        int col;
        boolean flag = false;
        System.out.println();
        showGame();
        System.out.println();
        if(g.isHumanPlayer()){
            System.out.println("\t\t\t1 - Play Piece \t\t2 - Play Special Piece");


            System.out.print("\n\t\tOption: ");
            while(!sc.hasNextInt())
                sc.next();

            op = sc.nextInt();

            do{
                System.out.print("\nColumn: ");
                while(!sc.hasNextInt())
                    sc.next();

                col = sc.nextInt();
                col -= 1;

                if(g.fullColumn(col))
                    System.out.println("\nERROR: The selected column is full, try another.");
                else
                    flag = true;

            }while (!flag);
        } else {
            XORShiftRandom xsr = new XORShiftRandom(7);
            col = xsr.nextInt();
            op = 1;
        }


        g.newPiece(op, col);


    }

    public void run(){
        while(true){
            printHeader();
            System.out.println();
            showMsgLog();
            g.clearMsgLog();

            if(g.isAwaitingSettings()) { printSettingsMenu(); }
            else
            if(g.isAwaitingPlay()) { printPlayMenu(); }
            else
            if(g.isAwaitingMiniGame()) { printMiniGameMenu(); }
            else
            if(g.isAwaitingGameOver()) { printGameOverMenu(); }
        }
    }

    private void showMsgLog() {
        if(g.getMsgLog().size()>0){
            for(String msg:g.getMsgLog()){
                System.out.println("---> " + msg);
            }
        }
    }

    private void showGame(){
        System.out.println(g);
    }

}

