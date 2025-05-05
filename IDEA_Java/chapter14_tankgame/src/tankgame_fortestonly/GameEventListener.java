package tankgame_fortestonly;
import java.util.EventListener;

public interface GameEventListener extends EventListener {
    void onEvent(GameEvent event);
}
