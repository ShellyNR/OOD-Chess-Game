package Game;

import BoardUI.UIBoard;
import Component.Board;
import Player.*;
import GameHandler.GameHandler;

import java.util.ArrayList;
import java.util.List;

public class RegularGame implements Game{

    private GameHandler gameHendler;
    private List<Player> playersList;
    private Board initBoard;
    private UIBoard UIb;
    private static RegularGame single_instance = null;


    private RegularGame(){
        List<Player> playersList = new ArrayList<>();
        playersList.add(new HumanPlayer(true));
        playersList.add(new HumanPlayer(false));
        this.playersList = playersList;

        this.initBoard = new Board(); // create defualt board
        this.playersList = playersList;
    }

    public static RegularGame RegularGame()
    {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new RegularGame();
        }
        return single_instance;
    }

    @Override
    public void setUIBoard(UIBoard UIB) {
        this.UIb = UIB;
    }

    @Override
    public List<Player> getPlayersList() {
        return this.playersList;
    }
    @Override
    public void runGame() {
        this.gameHendler.handleGame();
    }

    @Override
    public String toString(){
        return "Regular game";
    }

}
