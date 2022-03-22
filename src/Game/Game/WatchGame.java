package Game;

import BoardUI.UIBoard;
import Component.Board;
import FamousPlay.*;
import GameHandler.*;
import Player.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WatchGame implements Game {


    private GameHandler gameHandler;
    private List<Player> playersList;
    private List<FamousPlay> watchList;
    private FamousPlay chosenPlay;
    private Board initBoard;
    private UIBoard UIb;
    private static WatchGame single_instance = null;


    private WatchGame() {
        List<FamousPlay> listP = new ArrayList<>();
        listP.add(new PlayA());
        this.watchList = listP;
        this.chosenPlay = generatePlay();
        this.initBoard = new Board(this.chosenPlay.getInitState()); // create default board

        List<Player> playersList = new ArrayList<>();
        playersList.add(new ComputerPlayer(true,this.chosenPlay.getAPlayerMovesForSolveQuiz()));
        playersList.add(new ComputerPlayer(false, this.chosenPlay.getBPlayerMovesForSolveQuiz()));
        this.playersList = playersList;
        this.gameHandler = new WatchGameHandler(this.playersList,this.initBoard,this.chosenPlay.isAPlayerStart());
    }

    public static WatchGame WatchGame(){
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new WatchGame();
        }
        return single_instance;
    }

    private FamousPlay generatePlay(){
        Random ran = new Random();
        int index = 0;

        // Returns number between 0 to (list_size-1)
        if (this.watchList.size() > 1) {
            index = ran.nextInt(this.watchList.size() - 1);
        }
        return this.watchList.get(index);
    }


    @Override
    public void setUIBoard(UIBoard UIB) {

    }

    @Override
    public List<Player> getPlayersList() {
        return this.playersList;
    }

    public String toString(){
        return "Watch game";
    }

    public void runGame() {
        //this.gameHandler.handleGame();
    }


}
