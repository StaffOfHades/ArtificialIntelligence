package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.ActorListener;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/3/15 for Artificial Intelligence
 */
public class Plan extends ActorState<Actor> {

    private static final String TAG = "Plan";

    public Plan() {
        super(TAG);
    }

    @Override
    public void enter(ActorListener listener) {
        Log.v(TAG, listener.toString() + " started to plan his next move");
    }

    @Override
    public void execute(ActorListener listener) {
        Log.v(TAG, listener.toString() + " came to a decision");
        listener.onChangeState(new Mine());
    }

    @Override
    public void exit(ActorListener listener) {
        Log.v(TAG, listener.toString() + " has finished planning");
    }
}
