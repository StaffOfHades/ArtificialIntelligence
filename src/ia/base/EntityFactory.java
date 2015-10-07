package ia.base;

import ia.world_interaction.*;

/**
 * Created by mauriciog on 8/21/15.
 */
public abstract class EntityFactory<E extends GameEntity> {

    public ManagerListener<E> createEntity(EntityManager<E> listener) {
        final EffectorListener<E> effectorListener = new Effector<E>(listener);
        final PercipientListener<E> percipientListener = createPercipientListener(effectorListener);
        final ManagerListener<E> managerListener = new Percipient<E>(percipientListener);
        return managerListener;
    }

    protected abstract PercipientListener<E> createPercipientListener(
            EffectorListener<E> effectorListener);

}
