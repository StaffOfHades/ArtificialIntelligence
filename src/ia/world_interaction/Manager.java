package ia.world_interaction;

import ia.base.EntityControl;
import ia.base.EntityFactory;
import ia.base.GameEntity;
import system.debugging.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauriciog on 8/21/15.
 */
public abstract class Manager<E extends GameEntity> implements EntityListener<E> {

    private static final String TAG = "Manager";
    private final List< ManagerListener<E> > mListeners;
    private final EntityFactory<E> mFactory;
    private final EntityControl<E> mControl;

    public Manager(EntityFactory<E> factory, EntityControl<E> control) {
        mFactory = factory;
        mControl = control;
        mListeners = new ArrayList< ManagerListener<E> >();
    }

    public void runGameTurn() {
        for (ManagerListener<E> listener : mListeners) {
            listener.onWorldUpdated();
        }
        mControl.runCycle();
    }

    public void addEntity() {
        addEntity(1);
    }

    public void addEntity(int num) {
        for (int i = 0; i < num; i++) {
            Log.v(TAG, "Adding an entity");
            mListeners.add( mFactory.createEntity(this) );
        }
    }


    @Override
    public void onWorldAffected() {

    }
}
