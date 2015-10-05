package system.view;


import ia.actor.common.actor.ActorControl;
import ia.actor.common.actor.ActorFactory;
import ia.actor.unique.ActorManager;
import system.debugging.Log;

/**
 * Created by mauriciog on 8/17/15.
 */
public class ConsoleView {

    private static final String TAG = "Game View";
    private static final int GAME_TURNS = 20;

    public static void main(String[] args) {
        ActorManager manager = ActorManager.getInstance( ActorFactory.getInstance(), ActorControl.getInstance() );
        manager.addEntity(1);
        for (int i = 0; i < GAME_TURNS; i++) {
            Log.v(TAG, "Staring game turn " + i);
            manager.runGameTurn();
        }
    }
}
