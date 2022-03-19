package Quiz;

import Component.Move;

import java.util.List;

public interface Quiz {

    public char[][] getInitState();
    public char[][] setInitState();
    public List<Move> setPlayerMovesForSolveQuiz();
    public List<Move> setComputerMovesForSolveQuiz();
    public List<Move> getPlayerMovesForSolveQuiz();
    public List<Move> getComputerMovesForSolveQuiz();
    public boolean isPlayerStart();
    public boolean isPlayerWhite();
    public String toString();

}
