package Tools;

import Component.Board;
import Component.Move;
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

    public abstract boolean canMove(Move move);

    public abstract EnumTool getType();

    public boolean isKnight(){
        EnumTool et = this.getType();
        return (et == EnumTool.KnightW || et == EnumTool.KnightB);
    }

    public boolean isKing(){
        EnumTool et = this.getType();
        return (et == EnumTool.KingW || et == EnumTool.KingB);
    }

}