package Tools;

import Component.Board;
import Component.Move;
import Component.Spot;

public class Pawn extends Tool {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Move move) {
        boolean canMoveTwice = false;
        int direction;

        if(isWhite()){
            direction = -1;
            if (move.getStart().getX() == Board.LENGTH - 2) {
                canMoveTwice = true;
            }
        } else {
            direction = 1;
            if (move.getStart().getX() == Board.LENGTH + 1) {
                canMoveTwice = true;
            }
        }

        int x1 = move.getStart().getX();
        int y1 = move.getStart().getY();
        int x2 = move.getEnd().getX();
        int y2 = move.getEnd().getY();

        // walk
        if (y1 == y2 && ((x2 == x1 + direction) || ((x2 == x1 + direction*2) && canMoveTwice))) {
            return  move.getEnd().isEmpty();
        }

        // "kill"
        if (x2 == x1 + direction && (y2 == y1 + 1 || y2 == y1 - 1)) {
            return (!move.getEnd().isEmpty()) && move.getStart().getTool().isWhite() != move.getEnd().getTool().isWhite();
        }

        return false;
    }

    @Override
    public EnumTool getType() {
        return this.isWhite()? EnumTool.PawnW : EnumTool.PawnB;
    }

    @Override
    public String toString() {
        return "Pawn";
    }
}
