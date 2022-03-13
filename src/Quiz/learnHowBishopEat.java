package Quiz;

import Component.Move;
import Component.Spot;
import Tools.common;

import java.util.ArrayList;
import java.util.List;

public class learnHowBishopEat implements Quiz {

    private char[][] initBoard;
    private List<Move> movesForSolveQuiz;
    private boolean isPlayerStart;

    public learnHowBishopEat() {
        this.initBoard = getInitBoard();
        this.movesForSolveQuiz = getMovesForSolveQuiz();
        this.isPlayerStart = true;
    }

    public char[][] getInitBoard(){
        char[][] matrix = {{'R','e','B','e','e','B','K','R'},
                            {'P','P','P','e','e','e','P','P'},
                        {'e','e','n','e','e','e','e','e'},
                        {'e','e','e','K','P','e','e','e'},
                        {'e','e','b','e','e','e','e','e'},
                        {'e','e','e','e','e','e','e','e'},
                        {'p','p','p','p','e','p','p','p'},
                        {'r','k','b','e','k','e','e','r'}};
        return matrix;
    }

    public List<Move> getMovesForSolveQuiz(){
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move(new Spot(4,2, common.toolsCache.get("BishopW")),new Spot(3,3, common.toolsCache.get("BishopW"))));
        moveList.add(new Move(new Spot(0,2, common.toolsCache.get("BishopB")),new Spot(2,4, common.toolsCache.get("BishopB"))));
        moveList.add(new Move(new Spot(3,3, common.toolsCache.get("BishopW")),new Spot(2,4, common.toolsCache.get("BishopW"))));
        return moveList;
    }

}
