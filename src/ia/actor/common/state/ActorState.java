package ia.actor.common.state;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.ActorListener;
import ia.state.State;

/**
 * Actor State class for use with limited access to an actor listener. Used namely for any normal state
 * for an Actor or states that handle advance behavior. By limiting access, this class is particularly
 * safe.
 *
 * @param <E> An implementation of Actor
 */
public abstract class ActorState<E extends Actor> extends State<E> {


    public ActorState(String name) {
        super(name);
    }

    @Override
    public final void onEnter(E e) {
        enter(e);
    }

    @Override
    public final void onExecute(E e) {
        execute(e);
    }

    @Override
    public final void onExit(E e) {
        exit(e);
    }

    protected abstract void enter(ActorListener listener);
    protected abstract void execute(ActorListener listener);
    protected abstract void exit(ActorListener listener);
}
