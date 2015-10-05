package ia.world_interaction;

import ia.base.GameEntity;
import ia.state.State;

/**
 * Created by mauriciog on 8/19/15.
 */
public interface PercipientListener<E extends GameEntity> {

    void onPerceptionChanged();
    void onChangeState(State<E> state);
    void onRevertState();
    boolean onCompareState(State<E> state);
}
