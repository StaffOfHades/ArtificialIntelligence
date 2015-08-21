package actor;

import base.PhysicalState;
import type.PersonalityType;

import java.util.Random;
import java.util.UUID;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Actor implements PerceptorListener {

    private final Personality mPersonality;
    private final UUID mId;
    private final Stats mStats;
    private final Attributes mAttributes;
    private final PhysicalState mPhysicalState;
    private final EfectorListener mListener;

    public static Actor getInstance(int xAxis, int yAxis, EfectorListener listener) {
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
        return new Actor(type, xAxis, yAxis, listener);
    }

    private Actor(PersonalityType type, int xAxis, int yAxis, EfectorListener listener) {
        mPersonality = Personality.getInstance(type);
        mId = UUID.randomUUID();
        mStats = Stats.getInstance();
        mAttributes = Attributes.getInstance();
        mPhysicalState = new PhysicalState(xAxis, yAxis);
        mListener = listener;
    }

    @Override
    public void onPerceptionChanged() {
        System.out.println("Perception Changed");
        mListener.onActorDecision();
    }
}
