package tankgame_fortestonly;

import java.util.ArrayList;
import java.util.List;

public class GameEventBus {
    private static List<GameEventListener> listeners = new ArrayList<>();

    public static void register(GameEventListener listener) {
        listeners.add(listener);
    }

    public static void post(GameEvent event) {
        for (GameEventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
