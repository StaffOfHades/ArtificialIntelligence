package ia.actor.common.actor;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/7/15 for Artificial Intelligence
 */
public class Inventory {

    public int resource;

    public static Inventory newInstance() {
        return new Inventory();
    }

    private Inventory() {
        resource = 0;
    }

}
