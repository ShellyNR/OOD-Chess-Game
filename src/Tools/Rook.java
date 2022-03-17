package Tools;

import Component.Board;
import Component.Spot;

public class Rook extends Tool{


    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        // end is not an empty spot
        // end's tool can't have the same color tool as start's tool
        if (! end.getTool().toString().equals("Empty")) {
            if (end.getTool().isWhite() == this.isWhite()) {
                return false;
            }
        }




        return false;
    }

    @Override
    public String toString() {
        return "Rook";
    }
}
