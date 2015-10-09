package ia.actor.common.actor;

import ia.base.EntityControl;

import java.util.UUID;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/3/15 for Artificial Intelligence
 */
public class ActorControl extends EntityControl<Actor> {

    private static ActorControl sActorControl;

    public final static ActorControl getInstance() {
        if (sActorControl == null)
            sActorControl = new ActorControl();
        return sActorControl;
    }

    @Override
    protected final void registerEntity(Actor actor) {
        super.registerEntity(actor);
    }

    @Override
    protected final Actor getEntityById(UUID id) {
        return super.getEntityById(id);
    }

    @Override
    protected final boolean removeEntity(UUID id) {
        return super.removeEntity(id);
    }

    @Override
    protected final boolean removeEntity(Actor actor) {
        return removeEntity(actor.id);
    }

}
