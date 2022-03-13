package Tools;

import Component.Board;
import Component.Spot;
import Component.Spot;

public class Bishop extends Tool {
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
