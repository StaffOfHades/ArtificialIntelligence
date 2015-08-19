package base;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Attributes {

    private Attributes() {
        initValues();
    }

    private void initValues() {

    }

    public static Attributes getInstance() {
        return new Attributes();
    }
}
