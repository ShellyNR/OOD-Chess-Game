package GameHandler;

import Component.Board;
import Component.Move;
import Component.Spot;
import Player.Player;

import java.util.List;

public abstract class GameHandler {

    private GameStatus status;
    public Board board;
    private List<Player> playersList;
    private int turn;
    private int playersNumber;

    public GameHandler(Board board, List<Player> playersList, boolean isFirstStart) {
        this.board = board;
        this.playersList = playersList;
        this.playersNumber = playersList.size();
        if(isFirstStart){
            this.turn = 0;
        }else{
            this.turn = 1;
        }
        this.status = GameStatus.ACTIVE;
    }


    public boolean haveAWinner(){
        // white
        Spot kingSpotW = board.getKingSpotByColor(true);
        boolean ansW = checkIfKingIsUnderThreat(kingSpotW);
        // black
        Spot kingSpotB = board.getKingSpotByColor(false);
        boolean ansB = checkIfKingIsUnderThreat(kingSpotB);

        if(ansW){
            setStatus(GameStatus.BLACK_WIN);
            return true;
        }
        if(ansB){
            setStatus(GameStatus.WHITE_WIN);
            return true;
        }
        return false;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void updateTurn(){
        this.turn =  (getTurn() + 1 ) % getPlayersNumber();
    }

    public boolean isTurn(int index){
        return (index == this.turn);
    }

    public Player getPlayerTurn(int index){
        return this.playersList.get(index);
    }

    public boolean checkIfKingIsUnderThreat(Spot kingSpot){
        for(int i=0; i < Board.LENGTH; i++){
            for(int j = 0; j < Board.LENGTH; j++){
                Spot s = board.getSpot(i, j);
                if (s.getTool().isWhite() != kingSpot.getTool().isWhite()){
                    Move tempMove = new Move(s, kingSpot);
                    if ((tempMove.getStart().getTool().isKnight() || this.board.isFreeBetween(tempMove)) && tempMove.getStart().getTool().canMove(tempMove)) {
                        board.undo();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean willKingbeUnderThreat(Move move) {
        board.updateBoardByMove(move);
        Spot kingSpot = board.getKingSpotByColor(playersList.get(turn).isWhite());
        boolean ans = checkIfKingIsUnderThreat(kingSpot);
        board.undo();
        return ans;
    }

    public boolean checkMove(Move move){

        //play with empty "tool"
        if (move.getStart().isEmpty()){
            return false;
        }

        // staying in the same spot
        if (move.getStart().isEqual(move.getEnd())){
            return false;
        }

        // play with the "wrong" color
        if (!(playersList.get(turn).isWhite() == move.getStart().getTool().isWhite())){
                return false;
        }

        // "change" tool in during the move
        if (move.getStart().getTool() != move.getEnd().getTool()){
                return false;
        }

        // end is not an empty spot
        // end's tool can't have the same color tool as start's tool
        if (! move.getEnd().isEmpty()) {
            if (move.getEnd().getTool().isWhite() == move.getStart().getTool().isWhite()) {
                return false;
            }
        }

        if (!(move.getEnd().isInBoard() && move.getStart().isInBoard())){
            return false;
        }


        if (!((move.getStart().getTool().isKnight() || this.board.isFreeBetween(move)) && willKingbeUnderThreat(move) && move.getStart().getTool().canMove(move))){
            return false;
        }

        return true;
    }

    public boolean moveValidation(Move move){
        if(move == null){
            return false;
        }
        return checkMove(move);
    }

    public void handleGame(){
        while(!haveAWinner()){
            Move move = getPlayerTurn(this.turn).getNextMove();
            if(moveValidation(move)){
                board.updateBoardByMove(move);
                updateTurn();
            }else{
                System.out.println("Wrong Move, try again");
            }
        }
        declareWinner();
    }

    public void declareWinner(){
        if(getStatus() == GameStatus.WHITE_WIN){
            System.out.println("GAME OVER! the white player win!!");
        }
        if(getStatus() == GameStatus.BLACK_WIN){
            System.out.println("GAME OVER! the black player win!!");
        }
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public int getTurn() {
        return this.turn;
    }

    public int getPlayersNumber() {
        return playersNumber;
    }


}
