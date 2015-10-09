package ia.world_interaction;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 8/31/15 for Artificial Intelligence
 */
public class PathFinding {

    public final static int PAUSED = 0,
                            ACTIVE = 1;

    private int mState = PAUSED;

    protected static PathFinding getInstance() {
        return new PathFinding();
    }

    private PathFinding() {

    }

    protected boolean findPath(long x, long y) {
        return false;
    }

    protected void pause() {

    }

    protected void resume() {

    }

    protected int getState() {
        return mState;
    }
}
