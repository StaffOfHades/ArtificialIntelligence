package ia.state;

import ia.base.GameEntity;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/1/15 for Artificial Intelligence
 */
public abstract class State<E extends GameEntity> {

    public abstract void onEnter(final E entity);
    public abstract void onExecute(final E entity);
    public abstract void onExit(final E entity);
}
