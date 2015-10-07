package ia.state;

import ia.base.GameEntity;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/1/15 for Artificial Intelligence
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
    public String toString() {
        return mName;
    }

}
