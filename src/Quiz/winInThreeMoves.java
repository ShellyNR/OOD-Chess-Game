package Quiz;

import Component.Move;

import java.util.List;

public class winInThreeMoves implements Quiz{

    private char[][] initBoard;
    private List<Move> movesForSolveQuiz;
    private boolean isPlayerStart;

    public winInThreeMoves() {
        this.initBoard = getInitBoard();
        this.movesForSolveQuiz = getMovesForSolveQuiz();
        this.isPlayerStart = true;
    }

    @Override
    public char[][] getInitBoard() {
        return new char[0][];
    }

    @Override
    public List<Move> getMovesForSolveQuiz() {
        return null;
    }
}
