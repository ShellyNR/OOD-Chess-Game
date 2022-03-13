package Tools;

import Component.Board;
import Component.Spot;

public abstract class Tool {

    private boolean killed = false;
    private boolean white = false;

    public Tool(boolean white)
    {
        this.setWhite(white);
    }

    public boolean isWhite()
    {
        return this.white;
    }

    public void setWhite(boolean white)
    {
        this.white = white;
    }

    public boolean isKilled()
    {
        return this.killed;
    }

    public void setKilled(boolean killed)
    {
        this.killed = killed;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);
}