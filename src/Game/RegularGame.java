package Game;

import Component.Board;
import Player.Player;
import GameHendler.GameHandler;
import GameHendler.RegularGameHandler;

import java.util.List;

public class RegularGame implements Game{

    private GameHandler gameHendler;
    private List<Player> playersList;
    private Board initBoard;


    public RegularGame(List<Player> playersList) {
        this.initBoard = new Board(); // create defualt board
        this.playersList = playersList;
        this.gameHendler = new RegularGameHandler(this.playersList,this.initBoard);

    }

    @Override
    public void runGame() {

    }

    public String toString(){
        return "Regular game";
    }

}
