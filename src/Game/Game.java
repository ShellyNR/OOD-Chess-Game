package Game;

import BoardUI.UIBoard;
import Component.Board;
import FamousPlay.FamousPlay;
import GameHendler.GameHandler;
import Player.Player;
import Quiz.Quiz;

import java.util.List;

public interface Game {

    public void setUIBoard(UIBoard UIB);

    public List<Player> createPlayersList();

    public void runGame();

    public String toString();


}
