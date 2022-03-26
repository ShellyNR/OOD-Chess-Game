package FamousPlay;

import Component.Move;
import Component.Spot;
import Tools.EnumTool;
import Tools.Tool;
import Tools.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayA implements FamousPlay{


    private char[][] initState;
    private List<Move> APlayerMovesForSolveQuiz;
    private List<Move> BPlayerMovesForSolveQuiz;
    private boolean isAPlayerStart;
    private boolean isAPlayerWhite;
    HashMap<EnumTool, Tool> c = common.getInstance();

    public PlayA() {
        this.initState = setInitState();
        this.APlayerMovesForSolveQuiz = setAPlayerMovesForSolveQuiz();
        this.BPlayerMovesForSolveQuiz = setBPlayerMovesForSolveQuiz();
        this.isAPlayerStart = true;
        this.isAPlayerWhite = true;
    }

    @Override
    public char[][] getInitState() {
        return this.initState;
    }

    @Override
    public char[][] setInitState() {
        char[][] matrix = {{'R','N','B','Q','K','B','N','R'},
                {'P','P','P','P','P','P','P','P'},
                {'e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e'},
                {'e','e','e','e','e','e','e','e'},
                {'p','p','p','p','p','p','p','p'},
                {'r','n','b','q','k','b','n','r'}};
        return matrix;
    }

    @Override
    public List<Move> setAPlayerMovesForSolveQuiz() {
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move(new Spot(6,4, c.get(EnumTool.PawnW)),new Spot(4,4, c.get((EnumTool.Empty)))));
        moveList.add(new Move(new Spot(7,6, c.get(EnumTool.KnightW)),new Spot(5,5, c.get(EnumTool.Empty))));
        moveList.add(new Move(new Spot(7,1, c.get(EnumTool.KnightW)),new Spot(5,2, c.get(EnumTool.Empty))));
        moveList.add(new Move(new Spot(5,5, c.get(EnumTool.KnightW)),new Spot(3,4, c.get(EnumTool.PawnB))));
        return moveList;
    }

    @Override
    public List<Move> setBPlayerMovesForSolveQuiz() {
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move(new Spot(1,4, c.get(EnumTool.PawnB)),new Spot(3,4, c.get(EnumTool.Empty))));
        moveList.add(new Move(new Spot(0,1, c.get(EnumTool.KnightB)),new Spot(2,2, c.get(EnumTool.Empty))));
        moveList.add(new Move(new Spot(0,6, c.get(EnumTool.KnightB)),new Spot(2,5, c.get(EnumTool.Empty))));
        return moveList;
    }

    @Override
    public List<Move> getAPlayerMovesForSolveQuiz() {
        return APlayerMovesForSolveQuiz;
    }

    @Override
    public List<Move> getBPlayerMovesForSolveQuiz() {
        return BPlayerMovesForSolveQuiz;
    }

    @Override
    public boolean isAPlayerStart() {
        return isAPlayerStart;
    }

    @Override
    public boolean isAPlayerWhite() {
        return isAPlayerWhite;
    }

    @Override
    public String toString(){
        return "Baze vs Palmer";
    }

}
