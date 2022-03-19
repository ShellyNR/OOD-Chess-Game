package Game;

public class GameTest implements Game{
    @Override
    public void runGame() {
        System.out.println("run");
    }

    @Override
    public String toString(){
        return "Test Game";
    }
}
