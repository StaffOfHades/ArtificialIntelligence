package actor;

import manager.ActorListener;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Effector implements EfectorListener {

    private final ActorListener mListener;

    public static Effector getInstance(ActorListener listener) {
        return new Effector(listener);
    }

    private Effector(ActorListener listener) {
        mListener = listener;
    }

    @Override
    public void onActorDecision() {
        System.out.println("Actor Decision");
        mListener.onWorldAffected();
    }
}
