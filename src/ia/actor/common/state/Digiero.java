package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.state.State;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/5/15 for Artificial Intelligence
 */
public class Digiero extends State<Actor> {

    @Override
    public void onEnter(Actor entity) {
        Log.v("Digiero", "Actor va a empezar a digerir");
    }

    @Override
    public void onExecute(Actor entity) {
        Log.v("Digiero", "Actor digirio la comida");
        entity.onRevertState();
    }

    @Override
    public void onExit(Actor entity) {
        Log.v("Digiero", "Actor ya dirigio, y tiene hambre");
    }
}
