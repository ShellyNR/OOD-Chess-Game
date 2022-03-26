package Game;

import BoardUI.UIBoard;
import Component.Board;
import GameHandler.*;
import Player.*;
import Quiz.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuizGame implements Game{

    private UIBoard UIb;
    private GameHandler gameHandler;
    private List<Player> playersList;
    private List<Quiz> quizzesList;
    private Quiz chosenQuize;
    private Board initBoard;
    private static QuizGame single_instance = null;


    private QuizGame() {
        List<Quiz> listQ = new ArrayList<>();
        listQ.add(new learnHowBishopEat());
        listQ.add(new winInThreeMoves());
        this.quizzesList = listQ;

        this.chosenQuize = generateQuiz();
        this.initBoard = new Board(this.chosenQuize.getInitState());

        List<Player> playersList = new ArrayList<>();
        playersList.add(new Player(true,true, new HumanForQuizPlayer(this.chosenQuize.getPlayerMovesForSolveQuiz()))); //player
        playersList.add(new Player(false, false, new ComputerPlayer(this.chosenQuize.getComputerMovesForSolveQuiz()))); //computer

        this.playersList = playersList;
        this.gameHandler = new SimpleGameHandler(this.initBoard,this.playersList,this.chosenQuize.isPlayerStart());

    }

    public static QuizGame QuizGame()
    {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new QuizGame();
        }
        return single_instance;
    }

    @Override
    public void setUIBoard(UIBoard UIB) {
        this.UIb = UIB;
    }

    public Quiz generateQuiz(){
        Random ran = new Random();

        // Returns number between 0 to (list_size-1)
        int index = ran.nextInt(this.quizzesList.size() -1);
        return this.quizzesList.get(index);

    }
    @Override
    public List<Player> getPlayersList() {
        return playersList;
    }

    public String toString(){
        return "Quiz game";
    }

    public void runGame() {
        //this.gameHandler.handleGame();
    }
}
