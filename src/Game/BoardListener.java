package Game;
import Component.Move;

public interface BoardListener {
    // notify about a new move from the ui
    public void notify(Move move);
    // notify that the user asks to start a new game
    public void notifyNew();
}
