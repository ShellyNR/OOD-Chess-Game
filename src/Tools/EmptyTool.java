package Tools;

import Component.Board;
import Component.Spot;

public class EmptyTool extends Tool {


    public EmptyTool(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
