package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.state.State;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/7/15 for Artificial Intelligence
 */
public class BodyFunctions extends State<Actor> {

    private static final String TAG = "Body Functions";
    private static final int HUNGRY = 6;
    private static final int STARVING = 8;
    private static final int DEAD = 10;

    public BodyFunctions() {
        super(TAG);
    }

    @Override
    public void onEnter(Actor entity) {
        Log.v(TAG, entity.toString() + " is now alive");
    }

    @Override
    public void onExecute(Actor entity) {
        Log.v(TAG, entity.toString() + " has been alive for another turn");
        entity.getStats().hunger++;

        Log.v(TAG, entity.toString() + "'s hunger has gone up to " + entity.getStats().hunger);

        if (entity.getStats().hunger >= DEAD) {
            Log.v(TAG, entity.toString() + " should be dead due to hunger");
        } else if (entity.getStats().hunger >= STARVING) {
            Log.v(TAG, entity.toString() + " is in dire need of food");
            entity.forceLockedState(false);
            entity.onChangeState( new Eat() );
        } else if (entity.getStats().hunger >= HUNGRY) {
            entity.onChangeState(new Eat());
        }
    }

    @Override
    public void onExit(Actor entity) {
        Log.v(TAG, entity.toString() + " is now dead");
    }
}
