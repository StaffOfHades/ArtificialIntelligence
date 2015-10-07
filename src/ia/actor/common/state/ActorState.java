package ia.actor.common.state;

import ia.actor.common.actor.ActorListener;
import ia.base.GameEntity;
import ia.state.State;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/1/15 for Artificial Intelligence
 */
public abstract class ActorState<E extends GameEntity & ActorListener> extends State<E> {


    public ActorState(String name) {
        super(name);
    }

    @Override
    public void onEnter(E e) {
        enter(e);
    }

    @Override
    public void onExecute(E e) {
        execute(e);
    }

    @Override
    public void onExit(E e) {
        exit(e);
    }

    protected abstract void enter(ActorListener listener);
    protected abstract void execute(ActorListener listener);
    protected abstract void exit(ActorListener listener);
}
