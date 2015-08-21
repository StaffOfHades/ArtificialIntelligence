package manager;

import actor.*;

/**
 * Created by mauriciog on 8/21/15.
 */
public class ActorFactory {

    public static ManagerListener createActor(ActorListener listener) {
        final EfectorListener efectorListener = Effector.getInstance(listener);
        final PerceptorListener perceptorListener = Actor.getInstance(0, 0, efectorListener);
        final ManagerListener managerListener = Perceptor.getInstance(perceptorListener);
        return managerListener;
    }


}
