package Component;

public class Move {

//    private Player player;
    private Spot start;
    private Spot end;

    private boolean castlingMove = false;

    public Spot getStart() {
        return start;
    }

    public Spot getEnd() {
        return end;
    }

    public Move(Spot start, Spot end) {
        this.start = start;
        this.end = end;
    }

}
