package Game;

import java.util.ArrayList;
import java.util.List;

public class GameManager {


    private List<Game> listGamesOptions;
    private Game game;
    private UIGameManager UIGameManager;

    public GameManager(){
        listGamesOptions = new ArrayList<Game>();
        listGamesOptions.add(new QuizGame());


    }

    public List<Game> GetGameOptionsList(){
        return listGamesOptions;
    }

    public void ShowOptionsAndList(boolean white){
        for

    }

    public void createGame(){

    }

}
