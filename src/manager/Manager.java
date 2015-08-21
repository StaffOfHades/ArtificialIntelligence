package manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauriciog on 8/21/15.
 */
public class Manager implements ActorListener {

    private final List<ManagerListener> mListeners;

    public Manager() {
        mListeners = new ArrayList<ManagerListener>();
        for (int i = 0; i < 5; i++) {
            mListeners.add(ActorFactory.createActor(this));
            mListeners.get(i).onWorldUpdated();
            System.out.println();
        }

    }

    @Override
    public void onWorldAffected() {
        System.out.println("World Affected");
    }
}
