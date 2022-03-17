package GameHendler;

import Component.Board;
import Component.Move;
import Player.Player;

import java.util.List;

public class RegularGameHandler extends GameHandler{

    private Board board;
    private List<Player> playersList;
    private int turn;
    private int playersNumber;

    public RegularGameHandler(List<Player> playersList, Board initBoard) {
        this.board = initBoard;
        this.playersList = playersList;
        this.playersNumber = playersList.size();
        this.turn = 0;

    }

    public boolean isIndexWin(int indexPlayer) {
        return false;
    }


    public int checkWhoWin() {
        for(int i=0; i<this.playersNumber;i++){
            if(isIndexWin(i)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean haveAWinner() {
        // איום על המלך?? גם של הלבן וגם של השחור

        if (checkWhoWin() != -1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isTurn(int index) {
        return (index == turn);
    }


    @Override
    public Board makeMove(Board board, Move move) {
        if(!moveValidationReq(move)){
            System.out.println("wrong Move");
            return board;
        }
        if(move.getStart().getTool().canMove(board,move.getStart(),move.getEnd())){
            this.board.updateBoardByMove(move);

            this.turn = (this.turn + 1) % this.playersNumber;
        }
        return board;
    }

    @Override
    public void handleGame() {
        while(!haveAWinner()){


        }
        int winIndex = checkWhoWin();
        System.out.println("GAME OVER! Player " + this.turn + " win!!");

    }


}
