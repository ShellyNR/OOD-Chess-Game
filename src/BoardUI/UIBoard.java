package BoardUI;

import Component.Spot;
import Game.*;

import java.util.Set;

public interface UIBoard {

    public void initialize();

    public void show(Spot[][] currentPosition);

    public void addBoardListener(BoardListener boardListener);

}
