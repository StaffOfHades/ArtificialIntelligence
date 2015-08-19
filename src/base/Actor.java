package base;

import java.util.Random;
import java.util.UUID;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Actor {

    private final Personality mPersonality;
    private final UUID mId;
    private final Stats mStats;
    private final Attributes mAttributes;

    private Actor(PersonalityType type) {
        mPersonality = Personality.getInstance(type);
        mId = UUID.randomUUID();
        mStats = Stats.getInstance();
        mAttributes = Attributes.getInstance();
        initValues();
    }

    private void initValues() {

    }

    public static Actor getInstance() {
        final Random random = new Random();
        final int probability = random.nextInt(10);
        final PersonalityType type;
        if (probability >= 0 && probability < 5) {
            type = PersonalityType.Adaptable;
        } else if (probability < 8) {
            type = PersonalityType.Unyielding;
        } else if (probability < 9) {
            type = PersonalityType.Chaotic;
        } else {
            type = PersonalityType.Static;
        }
        return new Actor(type);
    }
}
