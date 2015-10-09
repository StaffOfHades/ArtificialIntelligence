package ia.state;

import ia.base.GameEntity;


/**
 * State class for use with direct access to a Game Entity. Used namely for global variables,
 * or states that handle advance behavior. Careful use is needed, since they have access
 * to particularly dangerous commands such as delete, or update;
 *
 * @param <E> GameEntity child over which this state will interact
 */
public abstract class State<E extends GameEntity> {

    private final String mName;

    public State(String name) {
        mName = name;
    }

    public abstract void onEnter(E entity);
    public abstract void onExecute(E entity);
    public abstract void onExit(E entity);

    @Override
    public final String toString() {
        return mName;
    }

}
