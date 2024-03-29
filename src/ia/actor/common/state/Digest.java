package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.ActorListener;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/5/15 for Artificial Intelligence
 */
public class Digest extends ActorState<Actor> {

    private static final String TAG = "Digest";

    public Digest() {
        super(TAG);
    }

    @Override
    public void enter(ActorListener listener) {
        Log.v(TAG, listener.toString() + " will start to digest");
    }

    @Override
    public void execute(ActorListener listener) {
        Log.v(TAG, listener.toString() + " is digesting");
        listener.onRevertStateBy(2);
    }

    @Override
    public void exit(ActorListener listener) {
        Log.v(TAG, listener.toString() + " has finished digesting");
    }
}
