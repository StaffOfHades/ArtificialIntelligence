package ia.state;

import ia.base.GameEntity;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/1/15 for Artificial Intelligence
 */
public abstract class State<E extends GameEntity> {

    public abstract void enter(final E entity);
    public abstract void execute(final E entity);
    public abstract void exit(final E entity);
}
