package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.ActorListener;
import ia.actor.common.actor.Attributes;
import system.debugging.Log;

import java.util.Random;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/5/15 for Artificial Intelligence
 */
public class Eat extends ActorState<Actor> {

    private static final String TAG = "Eat";

    public static ActorState<Actor> newInstance() {
        return new Eat();
    }

    private Eat() {
        super(TAG);
    }

    @Override
    public final void enter(ActorListener listener) {
        Log.v(TAG, listener.toString() + " is hungry ");
    }

    @Override
    public final void execute(ActorListener listener) {
        final Attributes attributes = listener.getAttributes();
        final Random random = new Random();
        attributes.hunger -= random.nextInt(3) + random.nextInt(3) + random.nextInt(3) + 2;
        if (attributes.hunger < 0)
            attributes.hunger = 0;
        Log.i(TAG, listener.toString() + " ate, and his hunger went down to " + attributes.hunger);
        listener.onChangeState( Digest.newInstance() );
    }

    @Override
    public final void exit(ActorListener listener) {
        Log.v(TAG, listener.toString() + " is full and now needs to digest");
    }
}
