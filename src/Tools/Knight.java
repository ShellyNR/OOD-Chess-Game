package Tools;

import Component.Board;
import Component.Spot;

public class Knight extends Tool {
    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
//    public Knight(boolean white)
//    {
//        super(white);
//    }
//
//    @Override
//    public boolean canMove(Board board, Spot start, Spot end)
//    {
//        // we can't move the piece to a spot that has
//        // a piece of the same colour
//        if (end.getPiece().isWhite() == this.isWhite()) {
//            return false;
//        }
//
//        int x = Math.abs(start.getX() - end.getX());
//        int y = Math.abs(start.getY() - end.getY());
//        return x * y == 2;
//    }
}
