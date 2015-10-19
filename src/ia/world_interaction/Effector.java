package ia.world_interaction;

import ia.base.GameEntity;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Effector<E extends GameEntity> implements EffectorListener<E> {

    private EntityListener<E> mListener;

    public Effector(EntityListener<E> listener) {
        mListener = listener;
    }

    @Override
    public final void onEntityDecision() {
        mListener.onWorldAffected();
    }

    @Override
    public final void onDeleteChain(CascadeDeleteListener<E> object) {
        mListener.onDeleteChain(object);
        mListener = null;
    }
}
