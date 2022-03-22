package Component;

import BoardUI.UIBoard;
import BoardUI.UIBoardGUI;
import Game.*;

import java.util.Hashtable;

public class GameManager implements MenuListener {


    //private List<Game> listGamesOptions;
    private Hashtable<String, Game> listGamesOptions;
    private UIGameMenu UIGameManager;
    private UIBoard UIb;

    public GameManager(UIGameMenu UIGameManager, Hashtable<String, Game> listGames, UIBoard UIB){
        this.listGamesOptions = listGames;
        this.UIb = UIB;
        this.UIGameManager = UIGameManager;
        this.UIGameManager.addMenuListener(this);

    }
    public Hashtable<String, Game> GetGameOptionsList(){
        return listGamesOptions;
    }


    public void createGame(){
        this.UIGameManager.show(this.listGamesOptions.keySet());
    }


    @Override
    public void notify(String s) {
        this.listGamesOptions.get(s).setUIBoard(this.UIb);
        this.listGamesOptions.get(s).runGame();
    }

    public static void main(String[] args){
        // choose the UI of the Board
        UIBoard UIBoardGame = new UIBoardGUI();

        // choose which games will appear in the menu.
        // different games can have different UI for board!
        Hashtable<String, Game> listGamesOptions = new Hashtable<String, Game>();
        Game quizGame =  QuizGame.QuizGame();
        Game regularGame =  RegularGame.RegularGame();
        Game gameTest =  GameTest.GameTest();
        Game watchGame =  WatchGame.WatchGame();

        listGamesOptions.put("Quiz Game", quizGame);
        listGamesOptions.put("Regular Game", regularGame);
        listGamesOptions.put("Game Test", gameTest);
        listGamesOptions.put("Watch Game", watchGame);

        UIGameMenu UIGameManager = new UIGameMenuJFrame();
        GameManager GM = new GameManager(UIGameManager, listGamesOptions, UIBoardGame);
        GM.createGame();
    }

}
