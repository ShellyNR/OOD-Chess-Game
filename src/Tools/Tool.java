package Tools;

import Component.Board;
import Component.Move;
import Component.Spot;

public abstract class Tool {

    private boolean isWhite;

    public Tool(boolean isWhite)
    {
        this.isWhite = isWhite;
    }

    public boolean isWhite()
    {
        return this.isWhite;
    }

    public abstract boolean canMove(Move move);

    public abstract EnumTool getType();

    public boolean isKnight(){
        EnumTool et = this.getType();
        return (et == EnumTool.KnightW || et == EnumTool.KnightB);
    }

    public boolean isKing(){
        EnumTool et = this.getType();
        return (et == EnumTool.KingW || et == EnumTool.KingB);
    }

    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Tool)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Tool c = (Tool) o;

        // Compare the data members and return accordingly
        return (this.isWhite == ((Tool) o).isWhite)
                && this.toString().equals(o.toString());
    }


}