package Game;

import BoardUI.UIBoard;
import Component.Board;
import Component.Move;
import Player.*;
import GameHandler.*;

import java.util.ArrayList;
import java.util.List;

public class RegularGame implements Game, BoardListener{

    private GameHandler gameHandler;
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

        this.gameHandler = new SimpleGameHandler(this.initBoard,this.playersList,true);
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
        this.UIb.addBoardListener(this);
    }

    @Override
    public List<Player> getPlayersList() {
        return this.playersList;
    }
    @Override
    public void runGame() {
        //this.gameHandler.handleGame();
        this.UIb.initialize();
        this.UIb.show(this.initBoard.getCurrentPosition());
    }

    @Override
    public String toString(){
        return "Regular game";
    }

    @Override
    public void notify(Move move) {
        if(this.gameHandler.moveValidation(move)) {
            this.gameHandler.handleGame(move);
            this.UIb.show(this.initBoard.getCurrentPosition());
        }
    }
}
