package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.state.State;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/3/15 for Artificial Intelligence
 */
public class Plan extends State<Actor> {

    private static final String TAG = "Plan";

    public static State<Actor> newInstance() {
        return new Plan();
    }

    private Plan() {
        super(TAG);
    }

    @Override
    public final void onEnter(Actor entity) {
        Log.v(TAG, entity.toString() + " started to plan his next move");
    }

    @Override
    public void onExecute(Actor entity) {
        Log.i(TAG, entity.toString() + " came to a decision");

        entity.onChangeState(Mine.newInstance());
    }

    @Override
    public final void onExit(Actor entity) {
        Log.v(TAG, entity.toString() + " has finished planning");
    }
}
