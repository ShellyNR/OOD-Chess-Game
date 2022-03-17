package Tools;

import Component.Board;
import Component.Spot;

public abstract class Tool {

    private boolean isWhite;

    public Tool(boolean isWhite)
    {
        this.isWhite = isWhite;
    }

    public boolean isWhite()
    {
        return this.isWhite;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);

    public abstract String toString();

}