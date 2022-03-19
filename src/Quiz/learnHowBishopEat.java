package Quiz;

import Component.Move;
import Component.Spot;
import Tools.common;

import java.util.ArrayList;
import java.util.List;

public class learnHowBishopEat implements Quiz {

    private char[][] initState;
    private List<Move> PlayerMovesForSolveQuiz;
    private List<Move> ComputerMovesForSolveQuiz;
    private boolean isPlayerStart;
    private boolean isPlayerWhite;

    public learnHowBishopEat() {
        this.initState = setInitState();
        this.PlayerMovesForSolveQuiz = setPlayerMovesForSolveQuiz();
        this.ComputerMovesForSolveQuiz = setComputerMovesForSolveQuiz();
        this.isPlayerStart = true;
        this.isPlayerWhite = true;

    }

    @Override
    public boolean isPlayerStart() {
        return isPlayerStart;
    }

    @Override
    public List<Move> getPlayerMovesForSolveQuiz() {
        return PlayerMovesForSolveQuiz;
    }

    @Override
    public List<Move> getComputerMovesForSolveQuiz() {
        return ComputerMovesForSolveQuiz;
    }

    @Override
    public boolean isPlayerWhite() {
        return isPlayerWhite;
    }

    @Override
    public char[][] getInitState() {
        return initState;
    }

    public char[][] setInitState(){
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

    public List<Move> setPlayerMovesForSolveQuiz(){
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move(new Spot(4,2, common.toolsCache.get("BishopW")),new Spot(3,3, common.toolsCache.get("BishopW"))));
        moveList.add(new Move(new Spot(3,3, common.toolsCache.get("BishopW")),new Spot(2,4, common.toolsCache.get("BishopW"))));
        return moveList;
    }

    public List<Move> setComputerMovesForSolveQuiz(){
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move(new Spot(0,2, common.toolsCache.get("BishopB")),new Spot(2,4, common.toolsCache.get("BishopB"))));
        return moveList;
    }

    @Override
    public String toString(){
        return "Bishop eat";
    }


}
