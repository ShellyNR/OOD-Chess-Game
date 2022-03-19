package GameHandler;

import Component.Board;
import Player.Player;

import java.util.List;

public class RegularGameHandler extends GameHandler{

    public RegularGameHandler(List<Player> playersList, Board initBoard) {
        super(initBoard, playersList,true);
    }

}
