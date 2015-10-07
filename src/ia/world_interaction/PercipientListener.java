package ia.world_interaction;

import ia.base.GameEntity;
import ia.characteristics.Stats;
import ia.characteristics.Vector2D;
import ia.message.Perception;

/**
 * Created by mauriciog on 8/19/15.
 */
public interface PercipientListener<E extends GameEntity> {
    void onPerceptionChanged(Perception perception);
    Stats getStats();
    Vector2D getVector2D();
}
