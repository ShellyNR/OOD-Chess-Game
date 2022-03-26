package Player;

import Component.Move;

public class Player {

    public boolean isWhite;
    public boolean isHumanPlayer;
    public PlayerType playerType;

    public Player(boolean isWhite, boolean isHumanPlayer, PlayerType playerType) {
        this.isWhite = isWhite;
        this.isHumanPlayer = isHumanPlayer;
        this.playerType = playerType;
    }

    public Player(boolean isWhite, boolean isHumanPlayer) {
        this.isWhite = isWhite;
        this.isHumanPlayer = isHumanPlayer;
    }

    public boolean isWhite()
    {
        return this.isWhite;
    }
    public boolean isHumanPlayer()
    {
        return this.isHumanPlayer;
    }
    public Move getNextMove(Move move){
        return playerType.getNextMove(move);
    }

}