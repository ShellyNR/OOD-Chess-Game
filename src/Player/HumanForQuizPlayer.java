package Player;

import Component.Move;

import java.util.List;

public class HumanForQuizPlayer extends HumanPlayer{

    private List<Move> moveList;
    private int moveIndex;

    public HumanForQuizPlayer(boolean isWhiteSide,  List<Move> moveList) {
        super(isWhiteSide);
        this.moveList = moveList;
        this.moveIndex = 0;
    }


    @Override
    public Move getNextMove() {
        Move moveFromUI = super.getNextMove();

        if (this.moveIndex == -1) {
            return null; // finish game, no more moves left
        }
        Move moveFromList = this.moveList.get(this.moveIndex);
        this.moveIndex = this.moveIndex + 1;
        if (this.moveIndex == this.moveList.size()) {
            this.moveIndex = -1;
        }

        if ((moveFromUI.getStart().isEqual(moveFromList.getStart())) &&
            (moveFromUI.getStart().isEqual(moveFromList.getEnd()))){
            return moveFromUI;
        }
        return null;

    }

}
