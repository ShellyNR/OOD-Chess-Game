package ListenerToBoard;

import Game.*;
import Component.*;
import java.awt.*;

public interface BoardNotifier {

    // add a component the listens to the notifier
    public void addBoardListener(BoardListener ml);

    // add a component that the notifier needs to listen to
    public Object addBoardNotifier(Object c);

    // notify listeners when the user asks for a new game
    public void NotifyNewBoard();
}
