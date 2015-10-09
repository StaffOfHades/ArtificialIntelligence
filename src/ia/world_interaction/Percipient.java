package ia.world_interaction;

import ia.base.GameEntity;
import ia.characteristics.Vector2D;
import ia.message.Perception;
import ia.message.WorldSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Percipient<E extends GameEntity> implements ManagerListener<E> {

    private PercipientListener<E> mListener;

    public Percipient(PercipientListener<E> listener) {
        mListener = listener;
    }

    @Override
    public final void onWorldUpdated(WorldSnapshot snapshot) {
        final Vector2D v1 = mListener.getVector2D();
        final List<Vector2D> vectors = snapshot.vectorList;
        final List<Vector2D> visibleVectors = new ArrayList<Vector2D>();
        for (Vector2D v2 : vectors) {
            if (v1.getSign(v2) == Vector2D.CLOCKWISE)
                visibleVectors.add(v2);
        }
        mListener.onPerceptionChanged( new Perception(visibleVectors) );
    }

    @Override
    public final void onCascadeDelete() {
        mListener.onDeleteChain( (SimpleManagerListener) this);
        mListener = null;
    }
}
