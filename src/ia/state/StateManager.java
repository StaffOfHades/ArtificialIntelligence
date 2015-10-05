package ia.state;

import ia.base.GameEntity;
import system.debugging.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/1/15 for Artificial Intelligence
 */
public class StateManager<E extends GameEntity> {

    private static final String TAG = "State Manager";
    private final E mOwner;
    private State<E> mCurrentState, mGlobalState;
    private final List< State<E> > mPreviousList;

    public StateManager(E owner) {
        mOwner = owner;
        mCurrentState = null;
        mGlobalState = null;
        mPreviousList = new ArrayList< State<E> >();
    }

    public void setGlobalState(State<E> globalState) {
        mGlobalState = globalState;
    }

    public void update() {
        Log.e(TAG, "Updating " + mOwner.toString());
        if (mGlobalState != null)
            mGlobalState.execute(mOwner);
        if (mCurrentState != null)
            mCurrentState.execute(mOwner);
    }

    public void changeState(State<E> newState) {
        mPreviousList.add(mCurrentState);
        Log.e(TAG, "Changing to state " + (mPreviousList.size() - 1) + " of " + mOwner.toString());
        if (mCurrentState != null)
            mCurrentState.exit(mOwner);
        mCurrentState = newState;
        mCurrentState.enter(mOwner);
    }

    public void revertToPreviousState() {
        if (mPreviousList.size() > 0) {
            Log.e(TAG, "Reverting to state " + (mPreviousList.size() - 1)  + " of " + mOwner.toString());
            mCurrentState.exit(mOwner);
            mCurrentState = mPreviousList.get( mPreviousList.size() - 1 );;
            mPreviousList.remove(mPreviousList.size() - 1);
            mCurrentState.enter(mOwner);
        }
    }

    public boolean isInState(State state) {
        return mCurrentState.equals(state);
    }
}
