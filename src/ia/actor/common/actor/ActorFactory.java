package ia.actor.common.actor;

import ia.base.EntityFactory;
import ia.world_interaction.EffectorListener;
import ia.world_interaction.PercipientListener;

/**
 * Created by mauriciog on 8/21/15.
 */
public class ActorFactory extends EntityFactory<Actor> {

    private static ActorFactory sActorFactory;

    public static ActorFactory getInstance() {
        if (sActorFactory == null) {
            sActorFactory = new ActorFactory();
        }
        return sActorFactory;
    }

    private ActorFactory() { }

    @Override
    protected PercipientListener<Actor> createPercipientListener(EffectorListener<Actor> effectorListener) {
        return Actor.newInstance(effectorListener);
    }
}
