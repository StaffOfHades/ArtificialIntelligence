package ia.message;

import ia.characteristics.Vector2D;
import ia.world_interaction.WorldStatus;

import java.util.List;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/7/15 for Artificial Intelligence
 */
public class WorldSnapshot {

    public final List<Vector2D> vectorList;

    public WorldSnapshot(WorldStatus status) {
        vectorList = status.getVectorList();
    }

}
