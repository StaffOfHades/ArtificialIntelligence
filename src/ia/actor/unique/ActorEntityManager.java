package ia.actor.unique;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.ActorControl;
import ia.actor.common.actor.ActorFactory;
import ia.world_interaction.EntityManager;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/4/15 for Artificial Intelligence
 */
public class ActorEntityManager extends EntityManager<Actor> {

    private static ActorEntityManager sActorManager;

    public static ActorEntityManager getInstance(ActorFactory factory, ActorControl control) {
        if (sActorManager == null)
            sActorManager = new ActorEntityManager(factory, control);
        return sActorManager;
    }

    private ActorEntityManager(ActorFactory factory, ActorControl control) {
        super(factory, control);
    }
}
