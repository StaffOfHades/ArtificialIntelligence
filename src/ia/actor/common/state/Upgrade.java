package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.ActorListener;
import system.debugging.Log;

import java.util.Random;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/19/15 for Artificial Intelligence
 */
public class Upgrade extends ActorState<Actor> {

    private final static String TAG = "Upgrade";

    public Upgrade() {
        super(TAG);
    }

    public static ActorState<Actor> newInstance() {
        return new Upgrade();
    }

    @Override
    protected void enter(ActorListener listener) {
        Log.v(TAG, "Actor will buy something");
    }

    @Override
    protected void execute(ActorListener listener) {
        final int upgrade = new Random().nextInt(3) + 2;
        listener.getInventory().resource -= 5;
        listener.getAttributes().changeStrength(upgrade, listener.getPersonality());
        Log.v(TAG, "Actor bought something");
        listener.onRevertState();
    }

    @Override
    protected void exit(ActorListener listener) {
        Log.v(TAG, "Actor finished buying");
    }
}
