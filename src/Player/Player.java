package Player;

import Component.Move;

public abstract class Player {

    public boolean isWhite;
    public boolean isHumanPlayer;

    public Player(boolean isWhite, boolean isHumanPlayer)
    {
        this.isWhite = isWhite;
        this.isHumanPlayer = isHumanPlayer;
    }


    public abstract Move getNextMove();
    public boolean isWhite()
    {
        return this.isWhite;
    }
    public boolean isHumanPlayer()
    {
        return this.isHumanPlayer;
    }


    public Move getNextMoveByList() {
        System.out.println("Wrong! regular Human Player");
        return null;

    }

}