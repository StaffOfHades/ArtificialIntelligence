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
    private E mOwner;
    private State<E> mCurrentState;
    private State<E> mGlobalState;
    private final List< State<E> > mPreviousList;

    public StateManager(E owner) {
        mOwner = owner;
        mCurrentState = null;
        mGlobalState = null;
        mPreviousList = new ArrayList< State<E> >();
    }

    public final void setGlobalState(State<E> globalState) {
        mGlobalState = globalState;
        Log.i(TAG,
                mOwner.toString() + " now has global state \"" + globalState.toString() + "\"");
        mGlobalState.onEnter(mOwner);
    }

    public final void update() {
        Log.i(TAG, mOwner.toString() + " updated to current turn");
        if (mGlobalState != null)
            mGlobalState.onExecute(mOwner);
        if (mCurrentState != null)
            mCurrentState.onExecute(mOwner);
    }

    public final void changeState(State<E> newState) {
        mPreviousList.add(mCurrentState);
        Log.i(TAG,
                mOwner + " changed to state " + ( mPreviousList.size() - 1 ) + ", \"" + newState.toString() + "\"");
        if (mCurrentState != null)
            mCurrentState.onExit(mOwner);
        mCurrentState = newState;
        mCurrentState.onEnter(mOwner);
    }

    public final void revertToPreviousState() {
        revertToPreviousStateBy(1);
    }

    public final void revertToPreviousStateBy(int times) {
        if (mPreviousList.size() - times >= 0) {
            State<E> previousState = mPreviousList.get( mPreviousList.size() - times );
            int previousNum = (mPreviousList.size() - times) - (mCurrentState != null ? 1 : 0);
            Log.i(TAG,
                    mOwner.toString() + " reverted to state " +  previousNum + ", \"" + previousState.toString() + "\"");
            mCurrentState.onExit(mOwner);
            mCurrentState = previousState;
            for (int i = 1; i <= times; i++) {
                mPreviousList.remove(mPreviousList.size() - i);
            }
            mCurrentState.onEnter(mOwner);
        }
    }

    public final boolean isInState(Class<? extends State<E>> stateClass) {
        return mCurrentState.getClass().equals(stateClass);
    }

    public final void delete() {
        mPreviousList.clear();
        mCurrentState = null;
        mGlobalState.onExit(mOwner);
        mOwner = null;
        mGlobalState = null;
    }
}
