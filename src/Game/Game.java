package Game;

import Component.Board;
import Component.Player;
import GameHendler.GameHendler;

import java.util.List;

public interface Game {

    private GameHendler gameHendler;
    private List<Player> playersList;
    private Board board;

    public void runGame();

    public String toString();



}
