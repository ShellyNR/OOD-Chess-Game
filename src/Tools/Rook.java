package Tools;

import Component.Board;
import Component.Spot;

public class Rook extends Tool{


    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
