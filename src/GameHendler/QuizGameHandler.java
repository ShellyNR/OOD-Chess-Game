package GameHendler;

import Component.Board;
import Component.Move;
import Player.Player;

import java.util.List;

public class QuizGameHandler extends GameHandler {

    public QuizGameHandler(List<Player> playersList, Board initBoard, boolean isFirstStart) {
        super(initBoard, playersList, isFirstStart);
    }

    @Override
    public boolean moveValidation(Move move) {
        if(!checkMove(move)){
            return false;
        }

        if(getPlayerTurn(getTurn()).isHumanPlayer) { // humanPlayer
            Move moveFromList = getPlayerTurn(getTurn()).getNextMoveByList();

            return ((move.getStart().isEqual(moveFromList.getStart())) &&
                    (move.getStart().isEqual(moveFromList.getEnd())));
        }
        return false;
    }

}
