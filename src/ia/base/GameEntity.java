package ia.base;

import ia.characteristics.Stats;
import ia.characteristics.Vector2D;
import system.debugging.Log;

import java.util.UUID;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/1/15 for Artificial Intelligence
 */
public abstract class GameEntity {

    private static final String TAG = "Game Entity";
    protected static int num = 0;

    protected final Stats mStats;
    protected final Vector2D mVector2D;

    public UUID id;
    public String name;

    public GameEntity(String name, Vector2D vector2D) {
        mVector2D = vector2D;
        this.name = name;
        id = UUID.randomUUID();

        mStats = Stats.newInstance();

        Log.d(TAG, "Creating " + toString());
    }


    public GameEntity(String name) {
        mVector2D = new Vector2D(true);
        this.name = name;
        id = UUID.randomUUID();

        mStats = Stats.newInstance();

        Log.d(TAG, "Creating " + toString());
    }

    public GameEntity() {
        this.name =  "Entity " + num;
        id = UUID.randomUUID();
        num++;

        mVector2D = new Vector2D(true);
        mStats = Stats.newInstance();

        Log.d(TAG, "Creating " + toString() );
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (object instanceof GameEntity) {
            return id.equals( ( (GameEntity) object ).id );
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract void update();

}
