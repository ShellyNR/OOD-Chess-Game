package GameHandler;

import Component.Board;
import Component.Move;
import Player.Player;

import java.util.List;

public class WatchGameHandler extends GameHandler {

    // first(White) - human, sec - computer
    public WatchGameHandler(List<Player> playersList, Board initBoard, boolean isFirstStart) {
        super(initBoard, playersList, isFirstStart);
    }

    @Override
    public boolean haveAWinner() {
        if (!super.haveAWinner()) {
            setStatus(GameStatus.FIN_WATCHING);
        }
        return false;
    }

    @Override
    public void declareWinner() {
        if (getStatus() == GameStatus.FIN_WATCHING) {
            System.out.println("GAME OVER! the game you watched finished");
        } else {
            super.declareWinner();
        }
    }


    @Override
    public void handleGame(Move m) {
        while (this.getTurn() != -1) {
            Move move = this.getPlayersList().get(this.getTurn()).getNextMove(null);
            if (moveValidation(move)) {
                board.updateBoardByMove(move);
                updateTurn();
            }
        }
        haveAWinner();
        declareWinner();
    }
}