package Game;

import Component.Board;
import Quiz.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizGame implements Game{

    private List<Quiz> quizzesList;


    public QuizGame() {
        this.quizzesList = getQuizzesList();

    }

    public List<Quiz> getQuizzesList() {
        List<Quiz> listQ = new ArrayList<>();
        listQ.add(new learnHowBishopEat());
        listQ.add(new winInThreeMoves());
        return listQ;
    }

    @Override
    public void runGame() {
        Quiz quiz = generateQuiz();
        Board board = new Board(quiz.getInitState());

    }

    public Quiz generateQuiz(){
        Random ran = new Random();

        // Returns number between 0 to (list_size-1)
        int index = ran.nextInt(this.quizzesList.size());
        return this.quizzesList.get(index);

    }

    public String toString(){
        return "Quiz game";
    }
}
