package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.ActorListener;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/5/15 for Artificial Intelligence
 */
public class Eat extends ActorState<Actor> {

    private static final String TAG = "Eat";

    public Eat() {
        super(TAG);
    }

    @Override
    public void enter(ActorListener listener) {
        Log.v(TAG, listener.toString() + " is hungry ");
    }

    @Override
    public void execute(ActorListener listener) {
        listener.getStats().hunger = 0;
        Log.v(TAG, listener.toString() + " ate, and now is full");
        listener.onChangeState(new Digest());
    }

    @Override
    public void exit(ActorListener listener) {
        Log.v(TAG, listener.toString() + " is full and now needs to digest");
    }
}
