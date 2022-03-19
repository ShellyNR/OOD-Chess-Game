package GameHandler;

import Component.Board;
import Component.Move;
import Player.Player;

import java.util.List;

public class QuizGameHandler extends GameHandler {

    public QuizGameHandler(List<Player> playersList, Board initBoard, boolean isFirstStart) {
        super(initBoard, playersList, isFirstStart);
    }

}
