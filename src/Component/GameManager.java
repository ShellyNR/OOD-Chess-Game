package Component;

import BoardUI.*;
import Game.*;


import java.util.Hashtable;

public class GameManager {


//    private List<Game> listGamesOptions;
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


    public void ShowOptionsAndList(boolean white){

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
        Game quizGame =  new QuizGame();
        Game regularGame =  new RegularGame();
        Game watchGame =  new WatchGame();

        listGamesOptions.put(quizGame.toString(), quizGame);
        listGamesOptions.put(regularGame.toString(), regularGame);
        listGamesOptions.put(watchGame.toString(), watchGame);

        UIGameMenu UIGameManager = new UIGameMenuJFrame();
        GameManager GM = new GameManager(UIGameManager, listGamesOptions, UIBoardGame);
        GM.createGame();
    }


}
