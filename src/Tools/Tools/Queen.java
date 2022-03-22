package Tools;

import Component.Board;
import Component.Move;
import Component.Spot;

public class Queen extends Tool  {


    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Move move) {
        return move.isInTheSameDiagonal() || move.isInTheSameRow() || move.isInTheSameColumn();
    }

    @Override
    public EnumTool getType() {
        return this.isWhite()? EnumTool.QueenW : EnumTool.QueenB;
    }

    @Override
    public String toString() {
        return "Queen";
    }
}
