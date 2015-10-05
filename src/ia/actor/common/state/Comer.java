package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.state.State;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/5/15 for Artificial Intelligence
 */
public class Comer extends State<Actor> {

    private static final String TAG = "Comer";

    @Override
    public void onEnter(Actor entity) {
        entity.hunger = 4;
        Log.v(TAG, entity.toString() + " tiene " + entity.hunger + " de hambre");
    }

    @Override
    public void onExecute(Actor entity) {
        entity.hunger--;
        Log.v(TAG, entity.toString() + " comio, y bajo su hambre a  " + entity.hunger);
        if (entity.hunger == 0)
            entity.onChangeState( new Digiero() );
    }

    @Override
    public void onExit(Actor entity) {
        Log.v(TAG, entity.toString() + " esta lleno, y tiene que digerir");
    }
}
