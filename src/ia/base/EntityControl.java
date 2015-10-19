package ia.base;

import system.debugging.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/1/15 for Artificial Intelligence
 */
public class EntityControl<E extends GameEntity> {

    private static final String TAG = "Entity Control";
    private final Map<UUID, E> mEntityMap;

    public EntityControl() {
        mEntityMap = new ConcurrentHashMap<UUID, E>();
    }

    protected void registerEntity(E entity) {
        Log.v(TAG, "Adding " + entity.toString() + " with id " + entity.id.toString(), Log.ANSI_YELLOW);
        mEntityMap.put(entity.id, entity);
    }

    protected E getEntityById(UUID id) {
        return  mEntityMap.get(id);
    }

    protected boolean removeEntity(UUID id) {
        if ( mEntityMap.containsKey(id) ) {
            mEntityMap.remove(id);
            return true;
        }
        return false;
    }

    protected boolean removeEntity(E entity) {
        return removeEntity(entity.id);
    }

    public void runCycle() {
        for (E entity : mEntityMap.values() ) {
            entity.update();
        }
    }


    public Map<String, Map<String, String>>  getEntityInfo() {
        final Map<String, Map<String, String>> mapList = new HashMap<>();
        for (E entity : mEntityMap.values() ) {
            mapList.put(entity.name, entity.getEntityInfo());
        }
        return mapList;
    }
}
