package ia.actor.common.actor;

import ia.actor.common.type.TraitType;
import system.debugging.Log;

import java.util.Random;

/**
 * Created by mauriciog on 8/14/15.
 */
public class Trait {

    private static final String TAG = "Trait";
    public final TraitType mType;
    private final Personality.ChangeVelocityHolder mHolder;
    private boolean hasTrait;
    private int mValue;

    public static Trait getInstance(TraitType type, boolean hasTrait,
                                    Personality.ChangeVelocityHolder holder) {
        final Random random = new Random();
        final int value = ( (random.nextInt(11)*10)+(random.nextInt(11)*10) )/2;
        return new Trait(type, hasTrait, hasTrait ? value : -value, holder);
    }

    public static Trait getInstance(TraitType type, boolean hasTrait,
                                    Personality.ChangeVelocityHolder holder, int value) {
        return new Trait(type, hasTrait, hasTrait ? value : -value, holder);
    }

    private Trait(TraitType type, boolean hasTrait, int value, Personality.ChangeVelocityHolder holder) {
        mType = type;
        mHolder = holder;
        mValue = value;
        this.hasTrait = hasTrait;

        Log.d(TAG, (hasTrait ? "Has" : "Doesn't have") + " trait \"" + mType +  "\" with value " + mValue);
    }

    public int getValue() {
        return mValue;
    }

    public boolean hasTrait() {
        return hasTrait;
    }

    public TraitType getType() {
        return mType;
    }

    public boolean change(boolean eventSuccessful, Trait adaptable) {
        if (adaptable.mType != TraitType.Adaptable) {
            new Exception(adaptable.toString() + " must be " + TraitType.Adaptable);
            return false;
        }
        if (mType == TraitType.Adaptable && mValue == 0) {
            return false;
        }
        final int change;
        if (eventSuccessful) {
            change = mHolder.changeVelocity *2;
        } else {
            change = mHolder.changeVelocity;
        }
        mValue += hasTrait ? change : -change;
        if (mValue > 100) {
            mValue = 100;
        }
        if (mValue < -100) {
            mValue = -100;
        }
        if (mType == TraitType.Adaptable && mValue == 0) {
            mValue += hasTrait ? 1 : -1;
        }

        final int trueValue = mValue > 0 ? mValue : -mValue;
        final int adaptability = 100 - adaptable.getValue();
        if ( adaptable.hasTrait && adaptability <= trueValue) {
            hasTrait = mValue >= 0;
        }
        return true;
    }
}
