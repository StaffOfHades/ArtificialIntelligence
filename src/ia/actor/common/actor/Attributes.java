package ia.actor.common.actor;

import ia.actor.common.type.TraitType;
import system.debugging.Log;

import java.util.Random;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Attributes {

    private final static int INCREASE_LIMIT= 4;
    private final static int MAX = 10;
    private static final String TAG = "Attributes";

    public int
            hunger = 0,
            hungryBorder,
            starvingBorder;
    private int mStrength,
            mHungerLimit;

    public static Attributes newInstance() {
        return new Attributes();
    }

    private Attributes() {
        final Random random = new Random();
        mStrength = ( random.nextInt(2) + 2) * 2 + random.nextInt(3);
    }

    private final void increaseAttribute(int attribute, int amount) {
        if ( (attribute == MAX && amount > 0)
                || (attribute == 0 && amount < 0) )
            return;

        if (Math.abs(amount) > INCREASE_LIMIT)
            amount = INCREASE_LIMIT * ( amount / Math.abs(amount) );

        attribute += amount;

        if (attribute > MAX)
            attribute = MAX;
        else if (attribute < 0)
            attribute = 0;
    }

    public final void changeStrength(int change, final Personality personality) {
        increaseAttribute(mStrength, change);
        mHungerLimit = (int) (mStrength * 1.6);

        final boolean isDiligent = personality.hasTrait(TraitType.Diligent);
        final boolean isAmbitious = personality.hasTrait(TraitType.Ambitious);
        final boolean isDaring = personality.hasTrait(TraitType.Daring);

        if (isAmbitious && isDiligent) {
            Log.d(TAG, "Both ambitious & diligent");
            hungryBorder = (int) (mStrength * .9);
        } else if (isDiligent) {
            Log.d(TAG, "Only diligent");
            hungryBorder = (int) (mStrength * .75);
        } else {
            Log.d(TAG, "Not diligent");
            hungryBorder = (int) (mStrength * .6);
        }

        if (isAmbitious && isDaring) {
            Log.d(TAG, "Both ambitious & daring");
            starvingBorder = (int) (mStrength * 1.40);
        } else if (isDaring) {
            Log.d(TAG, "Only daring");
            starvingBorder = (int) (mStrength * 1.20);
        } else {
            Log.d(TAG, "Not daring");
            starvingBorder = (int) (mStrength * 1);
        }

        Log.i(TAG, "Strength adjusted to " + mStrength);
        Log.d(TAG, "Total starvation reached at " + mHungerLimit);
        Log.d(TAG, "Starving reached  " + starvingBorder);
        Log.d(TAG, "Hunger limit adjusted to " + hungryBorder);
    }

    public final int getStrength() {
        return mStrength;
    }

    public final int getHungerLimit() {
        return mHungerLimit;
    }
}
