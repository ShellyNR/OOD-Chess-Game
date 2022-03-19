package BoardUI;

import Component.Spot;
import Game.MenuListener;

import javax.swing.event.MenuListener;

public interface UIBoard {

    public void show(Spot[][] currentPosition);

    public void addMenuListener(MenuListener menuListener);

}