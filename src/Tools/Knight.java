package Tools;

import Component.Board;
import Component.Move;
import Component.Spot;

public class Knight extends Tool {

    public Knight(boolean white)
    {
        super(white);
    }

    @Override
    public boolean canMove(Move move)
    {
        int x = Math.abs(move.getStart().getX() - move.getEnd().getX());
        int y = Math.abs(move.getStart().getY() - move.getEnd().getY());
        return x * y == 2; // 1,2 / 2,1
    }

    @Override
    public EnumTool getType() {
        return this.isWhite()? EnumTool.KnightW : EnumTool.KnightB;
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
