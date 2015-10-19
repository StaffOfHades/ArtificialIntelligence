package ia.base;

import ia.world_interaction.*;

/**
 * Created by mauriciog on 8/21/15.
 */
public abstract class EntityFactory<E extends GameEntity> {

    public ManagerListener<E> createEntity(EntityManager<E> listener) {
        final EffectorListener<E> effectorListener = new Effector<>(listener);
        final PercipientListener<E> percipientListener = createPercipientListener(effectorListener);
        final Percipient<E> percipient = new Percipient<>(percipientListener);
        percipientListener.setCascadeDeleteListener(percipient);
        return percipient;
    }

    protected abstract PercipientListener<E> createPercipientListener(
            EffectorListener<E> effectorListener);

}
