package BoardUI;

import Component.Move;
import Component.Spot;
import Game.*;
import ListenerToBoard.BoardNotifier;
import ListenerToBoard.MouseListenerToBoard;

import java.util.Set;

public interface UIBoard {

    // initialize the UI board
    public void initialize();

    // place the initial setting on the board
    void start(Spot[][] startPosition);

    // update the ui according to specific move
    public void show(Move move);

    // add a listener to the ui - mainly the game
    public void addBoardListener(BoardListener boardListener);

    // add a component that will notify the game when the user interacts with the ui
    public void setNotifier(BoardNotifier notifier);

}
