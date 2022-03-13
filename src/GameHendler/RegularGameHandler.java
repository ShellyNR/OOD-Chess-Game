package GameHendler;

import Component.Board;

public class RegularGameHandler implements GameHandler{


    @Override
    public boolean is_winning() {
        return false;
    }

    @Override
    public boolean is_turn() {
        return false;
    }

    @Override
    public Board make_move(Board board) {
        return null;
    }


}
