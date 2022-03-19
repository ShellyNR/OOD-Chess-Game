package Game;

import BoardUI.UIBoard;
import Component.Board;
import FamousPlay.*;
import GameHendler.*;
import Player.*;
import Quiz.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WatchGame implements Game {


    private GameHandler gameHendler;
    private List<Player> playersList;
    private List<FamousPlay> watchList;
    private FamousPlay chosenPlay;
    private Board initBoard;
    private UIBoard UIb;


    public WatchGame() {
        this.watchList = setWatchList();
        this.chosenPlay = generatePlay();
        this.initBoard = new Board(this.chosenPlay.getInitState()); // create default board
        this.playersList = createPlayersList();
        this.gameHendler = new WatchGameHandler(this.playersList,this.initBoard,this.chosenPlay.isAPlayerStart());

    }

    public List<FamousPlay> setWatchList() {
        List<FamousPlay> listP = new ArrayList<>();
        listP.add(new PlayA());
        return listP;

    }

    public FamousPlay generatePlay(){
        Random ran = new Random();

        // Returns number between 0 to (list_size-1)
        int index = ran.nextInt(this.watchList.size() - 1);
        return this.watchList.get(index);

    }

    @Override
    public void setUIBoard(UIBoard UIB) {

    }

    public List<Player> createPlayersList() {
        List<Player> playersList = new ArrayList<>();
        playersList.add(new ComputerPlayer(true,this.chosenPlay.getAPlayerMovesForSolveQuiz()));
        playersList.add(new ComputerPlayer(false, this.chosenPlay.getBPlayerMovesForSolveQuiz()));
        return playersList;
    }

    public String toString(){
        return "Watch game";
    }

    public void runGame() {
        this.gameHendler.handleGame();
    }


}
