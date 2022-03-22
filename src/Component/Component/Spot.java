package Component;

import Tools.EnumTool;
import Tools.Tool;

public class Spot {
    private Tool tool;
    private int x;
    private int y;

    public Spot(int x, int y, Tool tool)
    {
        this.tool = tool;
        this.x = x;
        this.y = y;
    }

    public Tool getTool() {
        return tool;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEmpty (){
        return this.tool.getType() == EnumTool.Empty;
    }

    public boolean isInBoard() {
        if((0 <= this.x) && (this.x < Board.LENGTH)){
            if((0 <= this.y) && (this.y < Board.LENGTH)){
                return true;
            }
        }
        return false;
    }

    public boolean isEqual(Spot other){
        return (this.x == other.x && this.y == other.y && this.tool == other.tool);
    }

}