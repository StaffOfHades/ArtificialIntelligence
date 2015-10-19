package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.Attributes;
import ia.state.State;
import system.debugging.Log;

import java.util.Random;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/7/15 for Artificial Intelligence
 */
public class BodyFunctions extends State<Actor> {

    private static final String TAG = "Body Functions";

    public static State<Actor> newInstance() {
        return new BodyFunctions();
    }

    private BodyFunctions() {
        super(TAG);
    }

    @Override
    public final void onEnter(Actor entity) {
        Log.v(TAG, entity.toString() + " is now alive");
    }

    @Override
    public void onExecute(Actor entity) {
        Log.v(TAG, entity.toString() + " has been alive for another turn");
        final Attributes attributes = entity.getAttributes();

        attributes.hunger += new Random().nextInt(2) + 1;

        Log.i(TAG, entity.toString() + "'s hunger has gone up to " + attributes.hunger);

        if ( attributes.hunger >= attributes.getHungerLimit() ) {
            Log.f(TAG, entity.toString() + " is dying due to hunger");
            entity.getStats().adjustHealth( new Random().nextInt(2) + 1 );
        } else if (attributes.hunger >= attributes.starvingBorder) {
            Log.w(TAG, entity.toString() + " is in dire need of food");
            entity.forceLockedState(false);
            entity.onChangeState( Eat.newInstance() );
        } else if (attributes.hunger >= attributes.hungryBorder) {
            entity.onChangeState( Eat.newInstance() );
        }
    }

    @Override
    public final void onExit(Actor entity) {
        Log.v(TAG, entity.toString() + " is now dead");
    }
}
