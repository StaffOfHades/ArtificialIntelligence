package ia.actor.common.actor;

import ia.state.State;
import ia.world_interaction.PercipientListener;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/6/15 for Artificial Intelligence
 */
public interface ActorListener extends PercipientListener<Actor> {

    Attributes getAttributes();
    Personality getPersonality();
    Inventory getInventory();

    void onRevertState();
    void onRevertStateBy(int times);
    void onChangeState(State<Actor> state);
    boolean onCompareState(Class<? extends State<Actor>> state);
}
