package ia.actor.common.actor;

import ia.base.EntityControl;

import java.util.UUID;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/3/15 for Artificial Intelligence
 */
public class ActorControl extends EntityControl<Actor> {

    private static ActorControl sActorControl;

    public static ActorControl getInstance() {
        if (sActorControl == null)
            sActorControl = new ActorControl();
        return sActorControl;
    }

    @Override
    protected void registerEntity(Actor actor) {
        super.registerEntity(actor);
    }

    @Override
    protected Actor getEntityById(UUID id) {
        return super.getEntityById(id);
    }

    @Override
    protected boolean removeEntity(UUID id) {
        return super.removeEntity(id);
    }

    @Override
    protected boolean removeEntity(Actor actor) {
        return removeEntity(actor.id);
    }

}
