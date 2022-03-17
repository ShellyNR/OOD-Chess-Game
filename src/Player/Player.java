package Player;

public abstract class Player {
    public boolean isWhiteSide;
    public boolean isHumanPlayer;

    public boolean isWhiteSide()
    {
        return this.isWhiteSide;
    }
    public boolean isHumanPlayer()
    {
        return this.isHumanPlayer;
    }
}