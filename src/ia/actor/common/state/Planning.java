package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.state.State;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/3/15 for Artificial Intelligence
 */
public class Planning extends State<Actor> {

    @Override
    public void enter(Actor entity) {
        Log.i(entity.toString(), "Started to think");
    }

    @Override
    public void execute(Actor entity) {
        Log.i(entity.toString(), "Came to a decision");
        entity.onChangeState( new Comer() );
    }

    @Override
    public void exit(Actor entity) {
        Log.i(entity.toString(), "Finished planning");
    }
}
