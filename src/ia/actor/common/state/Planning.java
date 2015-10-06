package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.state.State;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/3/15 for Artificial Intelligence
 */
public class Planning extends State<Actor> {

    private static final String TAG = "Planning";

    @Override
    public void onEnter(Actor entity) {
        Log.v(TAG, entity.toString() + " started to think");
    }

    @Override
    public void onExecute(Actor entity) {
        Log.v(TAG, entity.toString() + " came to a decision");
        entity.onChangeState( new Comer() );
    }

    @Override
    public void onExit(Actor entity) {
        Log.v(TAG, entity.toString() + " finished planning");
    }
}
