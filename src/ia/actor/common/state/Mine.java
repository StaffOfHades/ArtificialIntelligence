package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.ActorListener;
import system.debugging.Log;

import java.util.Random;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/3/15 for Artificial Intelligence
 */
public class Mine extends ActorState<Actor> {

    private static final String TAG = "Mine";

    public static ActorState<Actor> newInstance() {
        return new Mine();
    }

    private Mine() {
        super(TAG);
    }

    @Override
    public final void enter(ActorListener listener) {
        Log.v(TAG, listener.toString() + " is starting to mine");
    }

    @Override
    public final void execute(ActorListener listener) {
        int resources = new Random().nextInt(3) + 1;
        listener.getInventory().resource += resources;
        Log.i(TAG, listener.toString() + " mined " +  resources + " resource, now has " + listener.getInventory().resource + " pieces");
    }

    @Override
    public final void exit(ActorListener listener) {
        Log.v(TAG, listener.toString() + " is no longer mining");
    }
}
