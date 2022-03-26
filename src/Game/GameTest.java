package Game;

import BoardUI.UIBoard;
import Component.Board;
import GameHandler.*;
import Player.*;

import java.util.ArrayList;
import java.util.List;

public class GameTest implements Game{

    private static GameTest single_instance = null;
    private GameHandler gameHandler;
    private List<Player> playersList;
    private Board initBoard;
    private UIBoard UIb;

    private GameTest(){
        List<Player> playersList = new ArrayList<>();
        playersList.add(new Player(true,true));
        playersList.add(new Player(false, true));
        this.playersList = playersList;

        this.initBoard = new Board(); // create defualt board
        this.gameHandler = new SimpleGameHandler(this.initBoard,this.playersList, true);
    }

    public static GameTest GameTest()
    {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new GameTest();
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
        System.out.println("run");
    }

    @Override
    public String toString(){
        return "Test Game";
    }
}
