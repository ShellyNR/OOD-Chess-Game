package Quiz;

import Component.Move;

import java.util.List;

public interface Quiz {

    public char[][] getInitBoard();
    public List<Move> getMovesForSolveQuiz();

}
