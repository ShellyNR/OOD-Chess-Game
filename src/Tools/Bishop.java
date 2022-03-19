package Tools;

import Component.Board;
import Component.Move;
import Component.Spot;
import Component.Spot;

public class Bishop extends Tool {

    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Move move) {
        return move.isInTheSameDiagonal();
    }

    @Override
    public EnumTool getType() {
        return this.isWhite()? EnumTool.BishopW : EnumTool.BishopB;
    }
}
