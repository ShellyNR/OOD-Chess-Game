package Game;
import java.util.Set;

public interface UIGameMenu {

    public void show(Set<String> op);

    public void addMenuListener(MenuListener menuListener);
}
