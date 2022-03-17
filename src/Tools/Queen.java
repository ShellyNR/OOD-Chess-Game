package Tools;

import Component.Board;
import Component.Spot;

public class Queen extends Tool  {


    public Queen(boolean isWhite) {
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

        String finColor = "B";
        if(start.getTool().isWhite()){
            finColor = "W";
        }
        if((common.toolsCache.get("Bishop"+ finColor).canMove(board,start,end)) || (common.toolsCache.get("Rook" + finColor).canMove(board,start,end))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Queen";
    }
}
