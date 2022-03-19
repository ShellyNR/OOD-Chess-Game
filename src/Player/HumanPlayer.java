package Player;

import Component.Move;

import java.util.List;

public class HumanPlayer extends Player {

    private List<Move> moveList;
    private int moveIndex;
    public HumanPlayer(boolean isWhiteSide)
    {
        super(isWhiteSide, true);
    }

    public Move getNextMove(){
        // from UI
        return null;
    }



}