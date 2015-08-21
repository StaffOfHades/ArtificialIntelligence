package actor;

import manager.ManagerListener;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Perceptor implements ManagerListener {

    private final PerceptorListener mListener;

    public static Perceptor getInstance(PerceptorListener listener) {
        return new Perceptor(listener);
    }

    private Perceptor(PerceptorListener listener) {
        mListener = listener;
    }

    @Override
    public void onManagerCommand(String command) {
        System.out.println("Manager Commands");
        mListener.onWorldUpdated();
    }
}