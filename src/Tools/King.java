package Tools;

import Component.Board;
import Component.Move;
import Component.Spot;

public class King extends Tool {
//    private boolean castlingDone = false;

    public King(boolean isWhite)
    {
        super(isWhite);
    }

    @Override
    public boolean canMove(Move move)
    {
        int x = Math.abs(move.getStart().getX() - move.getEnd().getX());
        int y = Math.abs(move.getStart().getY() - move.getEnd().getY());
        return (x + y == 1) || (move.isInTheSameDiagonal() && x + y == 2);
    }

    @Override
    public EnumTool getType() {
        return this.isWhite()? EnumTool.KingW : EnumTool.KingB;
    }
}
