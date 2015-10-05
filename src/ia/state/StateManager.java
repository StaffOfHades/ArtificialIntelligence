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
        Log.i(TAG, "Updating " + mOwner.toString());
        if (mGlobalState != null)
            mGlobalState.onExecute(mOwner);
        if (mCurrentState != null)
            mCurrentState.onExecute(mOwner);
    }

    public void changeState(State<E> newState) {
        mPreviousList.add(mCurrentState);
        Log.i(TAG,
                "Changing to state " + ( mPreviousList.size() - 1 ) + " of " + mOwner.toString());
        if (mCurrentState != null)
            mCurrentState.onExit(mOwner);
        mCurrentState = newState;
        mCurrentState.onEnter(mOwner);
    }

    public void revertToPreviousState() {
        if (mPreviousList.size() > 0) {
            Log.i(TAG,
                    "Reverting to state " + (mPreviousList.size() - 2)  + " of " + mOwner.toString());
            mCurrentState.onExit(mOwner);
            mCurrentState = mPreviousList.get( mPreviousList.size() - 1 );
            mPreviousList.remove(mPreviousList.size() - 1);
            mCurrentState.onEnter(mOwner);
        }
    }

    public boolean isInState(State state) {
        return mCurrentState.equals(state);
    }
}
