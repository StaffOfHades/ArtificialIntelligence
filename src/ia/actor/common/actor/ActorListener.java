package ia.actor.common.actor;

import ia.state.State;
import ia.world_interaction.PercipientListener;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/6/15 for Artificial Intelligence
 */
public interface ActorListener<E extends Actor> extends PercipientListener<Actor> {

    void onChangeState(State<E> state);
    void onRevertState();
    boolean onCompareState(State<E> state);
}
