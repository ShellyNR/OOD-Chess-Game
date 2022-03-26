package Quiz;

import Component.Move;
import Component.Spot;
import Tools.EnumTool;
import Tools.Tool;
import Tools.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class winInThreeMoves implements Quiz{

    private char[][] initState;
    private List<Move> PlayerMovesForSolveQuiz;
    private List<Move> ComputerMovesForSolveQuiz;
    private boolean isPlayerStart;
    private boolean isPlayerWhite;
    HashMap<EnumTool, Tool> c = common.getInstance();


    public winInThreeMoves() {
        this.initState = setInitState();
        this.PlayerMovesForSolveQuiz = setPlayerMovesForSolveQuiz();
        this.ComputerMovesForSolveQuiz = setComputerMovesForSolveQuiz();
        this.isPlayerStart = true;
        this.isPlayerWhite = true;
    }

    public boolean isPlayerStart() {
        return isPlayerStart;
    }

    public boolean isPlayerWhite() {
        return isPlayerWhite;
    }

    public List<Move> getPlayerMovesForSolveQuiz() {
        return PlayerMovesForSolveQuiz;
    }

    public List<Move> getComputerMovesForSolveQuiz() {
        return ComputerMovesForSolveQuiz;
    }

    @Override
    public char[][] getInitState() {
        return initState;
    }

    @Override
    public char[][] setInitState() {
        char[][] matrix = {{'R','R','e','e','e','e','K','e'},
                {'e','e','q','e','e','P','e','P'},
                {'e','e','e','e','e','e','P','e'},
                {'e','e','Q','e','e','e','e','e'},
                {'e','e','b','B','P','e','B','e'},
                {'e','e','e','e','e','e','e','e'},
                {'p','e','e','e','e','p','p','p'},
                {'b','e','r','e','e','e','k','e'}};
        return matrix;
    }

    @Override
    public List<Move> setPlayerMovesForSolveQuiz() {
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move(new Spot(1,2, c.get(EnumTool.QueenW)),new Spot(1,5, c.get(EnumTool.PawnB))));
        moveList.add(new Move(new Spot(1,5, c.get(EnumTool.QueenW)),new Spot(2,5, c.get(EnumTool.Empty))));
        moveList.add(new Move(new Spot(7,0, c.get(EnumTool.BishopW)),new Spot(2,5, c.get(EnumTool.BishopB))));
        return moveList;
    }

    @Override
    public List<Move> setComputerMovesForSolveQuiz() {
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move(new Spot(0,6, c.get(EnumTool.KingB)),new Spot(0,7, c.get(EnumTool.Empty))));
        moveList.add(new Move(new Spot(4,3, c.get(EnumTool.BishopB)),new Spot(2,5, c.get(EnumTool.QueenW))));
        return moveList;
    }

    @Override
    public String toString(){
        return "Win in three moves";
    }


}
