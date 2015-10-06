package ia.type;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 8/31/15 for Artificial Intelligence
 */
public class PathFinding {

    public final static int PAUSED = 0,
                            ACTIVE = 1;
    private String mWorldState;

    protected static PathFinding getInstance() {
        return new PathFinding();
    }

    private PathFinding() {

    }

    protected void setWorldState(String worldState) {
        mWorldState = worldState;
    }

    protected boolean findPath(long x, long y) {
        return false;
    }

    protected void pause() {

    }

    protected void resume() {

    }

    protected int getState() {
        return 0;
    }
}
