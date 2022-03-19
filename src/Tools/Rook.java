package Tools;

import Component.Board;
import Component.Move;
import Component.Spot;

public class Rook extends Tool{


    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Move move) {
        return move.isInTheSameRow() || move.isInTheSameColumn();
    }

    @Override
    public EnumTool getType() {
        return this.isWhite()? EnumTool.RookW : EnumTool.RookB;
    }


}
