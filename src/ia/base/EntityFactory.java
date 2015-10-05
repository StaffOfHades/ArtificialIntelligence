package ia.base;

import ia.characteristics.Vector2D;
import ia.world_interaction.*;

/**
 * Created by mauriciog on 8/21/15.
 */
public abstract class EntityFactory<E extends GameEntity> {

    public ManagerListener<E> createEntity(EntityListener<E> listener) {
        return createEntity(listener, new Vector2D(0, 0));
    }

    public ManagerListener<E> createEntity(EntityListener<E> listener, Vector2D v2) {
        final EffectorListener<E> effectorListener = new Effector<E>(listener);
        final PercipientListener<E> percipientListener = createPercipientListener(effectorListener, v2);
        final ManagerListener<E> managerListener = new Percipient<E>(percipientListener);
        return managerListener;
    }

    protected abstract PercipientListener<E> createPercipientListener(
            EffectorListener<E> effectorListener, Vector2D v2);

}
