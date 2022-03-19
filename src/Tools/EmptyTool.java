package Tools;

import Component.Board;
import Component.Move;
import Component.Spot;

public class EmptyTool extends Tool {

    public EmptyTool(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Move move) {
        return false;
    }

    @Override
    public EnumTool getType() {
        return EnumTool.Empty;
    }
}
