package Tools;

import Component.Board;
import Component.Spot;

public class King extends Tool {
//    private boolean castlingDone = false;

    public King(boolean isWhite)
    {
        super(isWhite);
    }

//
//    public boolean isCastlingDone()
//    {
//        return this.castlingDone;
//    }
//
//    public void setCastlingDone(boolean castlingDone)
//    {
//        this.castlingDone = castlingDone;
//    }

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
        if (x + y == 1) {
            return true;
        }
        return false;

//        return this.isValidCastling(board, start, end);
    }

    @Override
    public String toString() {
        return "King";
    }

//    private boolean isValidCastling(Board board, Spot start, Spot end)
//    {
//
//        if (this.isCastlingDone()) {
//            return false;
//        }
//        return true;
//
//        // Logic for returning true or false
//    }
//
//    public boolean isCastlingMove(Spot start, Spot end)
//    {
//        return false;
//        // check if the starting and
//        // ending position are correct
//    }
}
