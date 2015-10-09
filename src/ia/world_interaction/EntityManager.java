package ia.world_interaction;

import ia.base.EntityControl;
import ia.base.EntityFactory;
import ia.base.GameEntity;
import ia.characteristics.Vector2D;
import system.debugging.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauriciog on 8/21/15.
 */
public abstract class EntityManager<E extends GameEntity> implements EntityListener<E> {

    private static final String TAG = "Entity Manager";
    private final List< ManagerListener<E> > mListeners;
    private final EntityFactory<E> mFactory;
    private final EntityControl<E> mControl;
    private static WorldStatus sWorldStatus;

    public EntityManager(EntityFactory<E> factory, EntityControl<E> control) {
        mFactory = factory;
        mControl = control;
        mListeners = new ArrayList< ManagerListener<E> >();
        sWorldStatus = WorldStatus.getInstance();
    }

    public final void runGameTurn() {
        for (int i = 0; i < 6; i++) {
            sWorldStatus.getVectorList().clear();
            sWorldStatus.getVectorList().add( new Vector2D(true) );
        }
        for (ManagerListener<E> listener : mListeners) {
            listener.onWorldUpdated(sWorldStatus.getSnapshot());
        }
        mControl.runCycle();
    }

    public final void addEntity() {
        addEntity(1);
    }

    public final void addEntity(int num) {
        for (int i = 0; i < num; i++) {
            Log.i(TAG, "Creating an entity");
            mListeners.add( mFactory.createEntity(this) );
        }
    }

    @Override
    public final void onDeleteChain(ManagerListener<E> object) {
        Log.d(TAG, "Entity is no more");
        mListeners.remove(object);
    }
}
