package Component;

public class Move {

//    private Player player;
    private Spot start;
    private Spot end;

    private boolean castlingMove = false;

    public Move(Spot start, Spot end) {
        this.start = start;
        this.end = end;
    }

}
