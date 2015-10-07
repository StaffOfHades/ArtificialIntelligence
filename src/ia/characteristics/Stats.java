package ia.characteristics;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Stats {

    public int hunger;

    public static Stats newInstance() {
        return new Stats();
    }

    private Stats() {
        hunger = 0;
    }

}
