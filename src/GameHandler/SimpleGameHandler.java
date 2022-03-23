package GameHandler;

import Component.Board;
import Player.Player;

import java.util.List;

public class SimpleGameHandler extends GameHandler {
    public SimpleGameHandler(Board board, List<Player> playersList, boolean isFirstStart){
        super(board, playersList, isFirstStart);
    }
}
