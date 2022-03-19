package Game;

import BoardUI.UIBoard;
import Player.Player;

import java.util.List;

public interface Game {

    public void setUIBoard(UIBoard UIB);

    public List<Player> createPlayersList();

    public void runGame();

    public String toString();


}
