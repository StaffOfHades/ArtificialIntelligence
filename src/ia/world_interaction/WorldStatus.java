package ia.world_interaction;

import ia.characteristics.Vector2D;
import ia.message.WorldSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/7/15 for Artificial Intelligence
 */
public class WorldStatus {

    private static WorldStatus sWorldStatus;

    private List<Vector2D> mVectorList;

    protected static WorldStatus getInstance() {
        if (sWorldStatus == null)
            sWorldStatus = new WorldStatus();
        return sWorldStatus;
    }

    private WorldStatus() {
        mVectorList = new ArrayList<Vector2D>();
    }

    protected WorldSnapshot getSnapshot() {
        return new WorldSnapshot(sWorldStatus);
    }

    public List<Vector2D> getVectorList() {
        return mVectorList;
    }

}
