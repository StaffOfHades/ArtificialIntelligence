package ia.world_interaction;

import ia.base.GameEntity;

/**
 * Created by mauriciog on 8/21/15.
 */
public interface EntityListener<E extends GameEntity> extends DeleteListener< ManagerListener<E> > {

    void onWorldAffected();

}
