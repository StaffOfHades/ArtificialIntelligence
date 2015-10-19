package ia.world_interaction;

import ia.base.GameEntity;
import ia.message.WorldSnapshot;

/**
 * Created by mauriciog on 8/21/15.
 */
public interface ManagerListener<E extends GameEntity> {
    void onWorldUpdated(WorldSnapshot snapshot);
}
