package ia.world_interaction;

import ia.base.EntityControl;
import ia.base.EntityFactory;
import ia.base.GameEntity;
import ia.characteristics.Vector2D;
import system.debugging.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        mListeners = new ArrayList<>();
        sWorldStatus = WorldStatus.getInstance();
    }

    public final void runGameTurn() {
        for (int i = 0; i < 6; i++) {
            sWorldStatus.getVectorList().clear();
            sWorldStatus.getVectorList().add( new Vector2D(true) );
        }
        for (ManagerListener<E> listener : mListeners) {
            listener.onWorldUpdated( sWorldStatus.getSnapshot() );
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

    public final void publishEntityInfo() {
        Map<String, Map<String, String>> mInfoMap = mControl.getEntityInfo();
        java.util.Iterator<Map.Entry<String, Map<String, String>>> iterator = mInfoMap.entrySet().iterator();
        Log.i(TAG, "Final Results ", Log.ANSI_BLUE);

        Map.Entry<String, Map<String, String>> entry;
        Map<String, String> m;
        Map.Entry<String, String> e;
        Iterator<Map.Entry<String, String>> i;
        while ( iterator.hasNext()) {
            entry = iterator.next();
            Log.d(TAG, entry.getKey() + ":");
            m = entry.getValue();
            i = m.entrySet().iterator();
            while (i.hasNext()) {
                e = i.next();
                Log.v(TAG, e.getKey() + ": " + e.getValue());
            }
        }
    }

    @Override
    public final void onDeleteChain(CascadeDeleteListener<E> object) {
        try {
            mListeners.remove(object);
            Log.d(TAG, "Entity is no more");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
