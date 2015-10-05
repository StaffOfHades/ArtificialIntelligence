package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.state.State;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/3/15 for Artificial Intelligence
 */
public class Mining extends State<Actor> {

    @Override
    public void enter(Actor entity) {
        Log.w(entity.toString(), "Actor starting to mine");
    }

    @Override
    public void execute(Actor entity) {
        Log.w(entity.toString(), "Actor mined 1 resource, now has " + entity.gold++ + " pieces");
    }

    @Override
    public void exit(Actor entity) {
        Log.w(entity.toString(), "Actor is no longer mining");
    }
}
