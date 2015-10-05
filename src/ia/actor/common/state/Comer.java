package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.state.State;
import system.debugging.Log;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/5/15 for Artificial Intelligence
 */
public class Comer extends State<Actor> {

    @Override
    public void enter(Actor entity) {
        entity.hunger = 4;
        Log.f("Comer", "Actor tiene " + entity.hunger + " de hambre");
    }

    @Override
    public void execute(Actor entity) {
        entity.hunger--;
        Log.f("Comer", "Actor comio, y bajo su hambre a  " + entity.hunger);
        if (entity.hunger == 0)
            entity.onChangeState( new Digiero() );
    }

    @Override
    public void exit(Actor entity) {
        Log.f("Comer", "Actor esta lleno, y tiene que digerir");
    }
}
