package GameHendler;

import Component.Board;
import Component.Move;
import Player.Player;

import java.util.List;

public abstract class GameHandler {

    private Board board;
    private List<Player> playersList;
    private int turn;
    private int playersNumber;

    public abstract boolean haveAWinner();

    boolean isTurn(int index){
        return (index == this.turn);
    }

    public boolean moveValidationReq(Move move){

        //play with empty "tool"
        if(move.getStart().getTool().toString().equals("Empty")){
            return false;
        }

        // play with the "wrong" color
        if(playersList.get(turn).isWhiteSide()){ //player is white
            if(!move.getStart().getTool().isWhite()){ // tool is black
                return false;
            }
        }

        // end spot in board
        int x = move.getEnd().getX();
        int y = move.getEnd().getY();

        if((0 <= x) && (x <= 7)){
            if((0 <= y) && (y <= 7)){
                return true;
             }
        }
        return false;
    }

    public abstract Board makeMove(Board board, Move move);

    public  abstract void handleGame();

}
