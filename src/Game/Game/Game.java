package Game;

import BoardUI.UIBoard;
import Player.*;

import java.util.List;


public interface Game {

    public void setUIBoard(UIBoard UIB);

    public List<Player> getPlayersList();

    public void runGame();

    public String toString();
}
