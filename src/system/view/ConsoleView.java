package system.view;


import ia.actor.common.actor.ActorControl;
import ia.actor.common.actor.ActorFactory;
import ia.actor.unique.ActorEntityManager;
import system.debugging.Log;

/**
 * Created by mauriciog on 8/17/15.
 */
public class ConsoleView {

    private static final String TAG = "Game View";
    private static final int GAME_TURNS = 10;
    private static final int NUM_ACTORS = 1;

    public static void main(String[] args) {
        ActorEntityManager manager = ActorEntityManager.getInstance(ActorFactory.getInstance(), ActorControl.getInstance());
        manager.addEntity(NUM_ACTORS);
        for (int i = 0; i < GAME_TURNS; i++) {
            Log.i(TAG, "Staring game turn " + i, Log.ANSI_BLUE);
            manager.runGameTurn();
        }
    }
}
