package Tools;

import Component.Board;
import Component.Spot;

public class Queen extends Tool  {


    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
