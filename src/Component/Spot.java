package Component;

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


}
