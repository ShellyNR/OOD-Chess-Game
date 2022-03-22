package FamousPlay;

import Component.Move;

import java.util.List;

public interface FamousPlay {

    public char[][] getInitState();
    public char[][] setInitState();
    public List<Move> setAPlayerMovesForSolveQuiz();
    public List<Move> setBPlayerMovesForSolveQuiz();
    public List<Move> getAPlayerMovesForSolveQuiz();
    public List<Move> getBPlayerMovesForSolveQuiz();
    public boolean isAPlayerStart();
    public boolean isAPlayerWhite();
    public String toString();

}
