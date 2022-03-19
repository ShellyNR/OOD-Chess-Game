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

    public boolean isInTheSameRow(){
        return start.getX() == end.getX();
    }

    public boolean isInTheSameColumn(){
        return start.getY() == end.getY();
    }

    public boolean isInTheSameDiagonal(){
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x == y;
    }

}
