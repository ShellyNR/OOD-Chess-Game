package Tools;

import Component.Board;
import Component.Spot;

public class EmptyTool extends Tool {


    public EmptyTool(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }

    @Override
    public String toString() {
        return "Empty";
    }
}
