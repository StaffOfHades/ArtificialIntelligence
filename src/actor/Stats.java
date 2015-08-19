package actor;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Stats {

    private Stats() {
        initValues();
    }

    private void initValues() {

    }

    public static Stats getInstance() {
        return new Stats();
    }

}
