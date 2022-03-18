package Game;

import java.util.Hashtable;

public class GameManager implements MenuListener {


    //private List<Game> listGamesOptions;
    private Hashtable<String, Game> listGamesOptions;
    private Game game;
    private UIGameMenu UIGameManager;

    public GameManager(UIGameMenu UIGameManager){

        listGamesOptions = new Hashtable<String, Game>();
        listGamesOptions.put("Quiz Game", new QuizGame());
        listGamesOptions.put("Regular Game", new RegularGame());
        listGamesOptions.put("Game Test", new GameTest());

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
        this.listGamesOptions.get(s).runGame();
    }

    public static void main(String[] args){
        UIGameMenu UIGameManager = new UIGameMenuJFrame();
        GameManager GM = new GameManager(UIGameManager);
        GM.createGame();
    }

}
