public interface GameHandler {

    public boolean is_winning();

    public boolean is_turn();

    public Board make_move(Board board);

}
