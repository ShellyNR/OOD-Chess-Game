package Component;

public class Move {

    //    private Player player;
    private Spot start = null;
    private Spot end = null;

    private boolean castlingMove = false;

    public Spot getStart() {
        return start;
    }

    public Spot getEnd() {
        return end;
    }

    public Move(Spot start) {
        this.start = start;
    }

    public Move(Spot start, Spot end) {
        this.start = start;
        this.end = end;
    }

    public void setEnd(Spot end) {
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