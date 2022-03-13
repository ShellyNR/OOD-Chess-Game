package Game;

import Quiz.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizGame implements Game{

    private List<Quiz> quizzesList;

    public QuizGame() {
        this.quizzesList = new ArrayList<>();
        this.quizzesList.add(new learnHowBishopEat());
        this.quizzesList.add(new winInThreeMoves());
    }

    @Override
    public void runGame() {
        Quiz quiz = generateQuiz();
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
