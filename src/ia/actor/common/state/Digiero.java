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
    public void enter(Actor entity) {
        Log.d("Digiero", "Actor va a empezar a digerir");
    }

    @Override
    public void execute(Actor entity) {
        Log.d("Digiero", "Actor digirio la comida");
        entity.onRevertState();
    }

    @Override
    public void exit(Actor entity) {
        Log.d("Digiero", "Actor ya dirigio, y tiene hambre");
    }
}
