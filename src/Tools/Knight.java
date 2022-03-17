package Tools;

import Component.Board;
import Component.Spot;

public class Knight extends Tool {

    public Knight(boolean white)
    {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end)
    {
        // end is not an empty spot
        // end's tool can't have the same color tool as start's tool
        if (! end.getTool().toString().equals("Empty")) {
            if (end.getTool().isWhite() == this.isWhite()) {
                return false;
            }
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x * y == 2; // 1,2 / 2,1
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
