package ia.world_interaction;

import ia.base.GameEntity;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Percipient<E extends GameEntity> implements ManagerListener<E> {

    private final PercipientListener<E> mListener;

    public Percipient(PercipientListener<E> listener) {
        mListener = listener;
    }

    @Override
    public void onWorldUpdated() {
        mListener.onPerceptionChanged();
    }
}
