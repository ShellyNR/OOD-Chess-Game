package GameHendler;

import Component.Board;
import Component.Move;
import Player.Player;

import java.util.List;

public class WatchGameHandler extends GameHandler{

    // first(White) - human, sec - computer
    public WatchGameHandler(List<Player> playersList, Board initBoard, boolean isFirstStart) {
        super(initBoard, playersList, isFirstStart);
    }

    @Override
    public void handleGame() {
        while (this.getTurn() != -1){
            Move move = this.getPlayersList().get(this.getTurn()).getNextMove();
            moveValidation(move);
        }
    }
}
