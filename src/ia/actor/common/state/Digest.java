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

    public static ActorState<Actor> newInstance() {
        return new Digest();
    }

    private Digest() {
        super(TAG);
    }

    @Override
    public final void enter(ActorListener listener) {
        Log.v(TAG, listener.toString() + " will start to digest");
    }

    @Override
    public final void execute(ActorListener listener) {
        Log.i(TAG, listener.toString() + " is digesting");
        listener.onRevertStateBy(2);
    }

    @Override
    public final void exit(ActorListener listener) {
        Log.v(TAG, listener.toString() + " has finished digesting");
    }
}
