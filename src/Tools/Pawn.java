package Tools;

import Component.Board;
import Component.Spot;

public class Pawn extends Tool {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
