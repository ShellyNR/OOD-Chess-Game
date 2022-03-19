package Game;

import Component.Board;
import Player.*;
import GameHendler.*;
import BoardUI.UIBoard;

import java.util.ArrayList;
import java.util.List;

public class RegularGame implements Game{

    private GameHandler gameHendler;
    private List<Player> playersList;
    private Board initBoard;
    private UIBoard UIb;


    public RegularGame() {
        this.initBoard = new Board(); // create defualt board
        this.playersList = createPlayersList();
        this.gameHendler = new RegularGameHandler(this.playersList,this.initBoard);

    }

    @Override
    public void setUIBoard(UIBoard UIB) {
        this.UIb = UIB;
    }

    public List<Player> createPlayersList() {
        List<Player> playersList = new ArrayList<>();
        playersList.add(new HumanPlayer(true));
        playersList.add(new HumanPlayer(false));
        return playersList;
    }

    public String toString(){
        return "Regular game";
    }

    public void runGame() {
        this.gameHendler.handleGame();
    }


}
