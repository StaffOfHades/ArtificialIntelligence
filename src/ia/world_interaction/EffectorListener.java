package ia.world_interaction;

import ia.base.GameEntity;

/**
 * Created by mauriciog on 8/19/15.
 */
public interface EffectorListener<E extends GameEntity> {
    void onEntityDecision();
}
