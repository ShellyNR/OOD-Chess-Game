package Game;

import BoardUI.UIBoard;
import Component.Board;
import Component.Move;
import Component.Spot;
import Player.*;
import GameHandler.*;

import java.util.ArrayList;
import java.util.List;

public class RegularGame implements Game, BoardListener{

    private GameHandler gameHandler;
    private List<Player> playersList;
    private Board initBoard = null;
    private UIBoard UIb;
    private static RegularGame single_instance = null;


    private RegularGame(){
        List<Player> playersList = new ArrayList<>();
        playersList.add(new HumanPlayer(true));
        playersList.add(new HumanPlayer(false));
        this.playersList = playersList;

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
        // the game listens to changes on the board ui
        this.UIb.addBoardListener(this);
    }

    @Override
    public List<Player> getPlayersList() {
        return this.playersList;
    }
    @Override
    public void runGame() {
        this.UIb.initialize();
    }

    @Override
    public String toString(){
        return "Regular game";
    }

    @Override
    public void notify(Move move) {
        if (move == null) return;
        // since the notifier knows only the certain move and not the entire board,
        // the game gets the move from the notifier and adds needed fields - the tools at the start and the end,
        // and then validates the move using the game handler.
        move.getStart().setTool(this.initBoard.getCurrentPosition()[move.getStart().getX()][move.getStart().getY()].getTool());
        move.getEnd().setTool(this.initBoard.getCurrentPosition()[move.getEnd().getX()][move.getEnd().getY()].getTool());
        if(this.gameHandler.moveValidation(move)) {
            this.gameHandler.handleGame(move);
            this.UIb.show(move);
        }
    }

    @Override
    public void notifyNew() {
        this.initBoard = new Board();
        this.gameHandler.setBoard(this.initBoard);
        this.UIb.start(this.initBoard.getCurrentPosition());
    }
}
