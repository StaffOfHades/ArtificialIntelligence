package ia.actor.unique;

import ia.actor.common.actor.Actor;
import ia.actor.common.actor.ActorControl;
import ia.actor.common.actor.ActorFactory;
import ia.world_interaction.Manager;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/4/15 for Artificial Intelligence
 */
public class ActorManager extends Manager<Actor> {

    private static ActorManager sActorManager;

    public static ActorManager getInstance(ActorFactory factory, ActorControl control) {
        if (sActorManager == null)
            sActorManager = new ActorManager(factory, control);
        return sActorManager;
    }

    private ActorManager(ActorFactory factory, ActorControl control) {
        super(factory, control);
    }
}
