package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.state.State;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/3/15 for Artificial Intelligence
 */
public class Mining extends State<Actor> {

    private static final String TAG = "Mining";

    @Override
    public void onEnter(Actor entity) {
        Log.v(TAG, entity.toString() + " is starting to mine");
    }

    @Override
    public void onExecute(Actor entity) {
        Log.v(TAG, entity.toString() + " mined 1 resource, now has " + entity.gold++ + " pieces");
    }

    @Override
    public void onExit(Actor entity) {
        Log.v(TAG, entity.toString() + " is no longer mining");
    }
}
