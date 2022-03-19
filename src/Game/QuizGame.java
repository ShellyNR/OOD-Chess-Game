package Game;

import BoardUI.UIBoard;
import Component.*;
import GameHendler.*;
import Player.*;
import Quiz.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizGame implements Game{

    private UIBoard UIb;
    private GameHandler gameHendler;
    private List<Player> playersList;
    private List<Quiz> quizzesList;
    private Quiz chosenQuize;
    private Board initBoard;



    public QuizGame() {
        this.quizzesList = setQuizzesList();
        this.chosenQuize = generateQuiz();
        this.initBoard = new Board(this.chosenQuize.getInitState());
        this.playersList = createPlayersList();
        this.gameHendler = new QuizGameHandler(this.playersList,this.initBoard,this.chosenQuize.isPlayerStart());

    }

    public List<Quiz> setQuizzesList() {
        List<Quiz> listQ = new ArrayList<>();
        listQ.add(new learnHowBishopEat());
        listQ.add(new winInThreeMoves());
        return listQ;
    }

    public Quiz generateQuiz(){
        Random ran = new Random();

        // Returns number between 0 to (list_size-1)
        int index = ran.nextInt(this.quizzesList.size() -1);
        return this.quizzesList.get(index);

    }

    @Override
    public void setUIBoard(UIBoard UIB) {
        this.UIb = UIB;
    }

    public List<Player> createPlayersList() {
        List<Player> playersList = new ArrayList<>();
        playersList.add(new HumanForQuizPlayer(true,this.chosenQuize.getPlayerMovesForSolveQuiz())); //player
        playersList.add(new ComputerPlayer(false, this.chosenQuize.getComputerMovesForSolveQuiz())); //computer
        return playersList;
    }

    public String toString(){
        return "Quiz game";
    }

    public void runGame() {
        this.gameHendler.handleGame();
    }

}
