package ia.actor.common.actor;

import ia.actor.common.type.PersonalityType;
import ia.actor.common.type.TraitType;
import system.debugging.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by mauriciog on 8/14/15.
 */
public class Personality {

    private static final String TAG = "Stats";
    private final PersonalityType mType;
    private final Map<TraitType, Trait> mTraitMap;
    private final ChangeVelocityHolder mHolder;
    private final boolean isAdaptable;

    public static Personality newInstance(PersonalityType type) {
        final Random random = new Random();
        final int rate = ( (random.nextInt(6))+(random.nextInt(6)) )/2;
        final int velocity = type == PersonalityType.Static ? 0 : rate > 0 ? rate : 1;
        final boolean adaptable;
        switch (type) {
            case Chaotic:
            case Adaptable:
                adaptable = true;
                break;
            case Static:
            case Unyielding:
            default:
                adaptable = false;
                break;
        }
        return new Personality(type, velocity, adaptable);
    }

    private Personality(PersonalityType type, int changeVelocity, boolean adaptable) {
        mType = type;
        mTraitMap = new HashMap<TraitType, Trait>();
        mHolder = new ChangeVelocityHolder(changeVelocity);
        isAdaptable = adaptable;

        Log.d(TAG, (isAdaptable ? "A" : "Non a") + "daptable personality type \"" + mType + "\" with change velocity of " + mHolder.changeVelocity);

        initValues();
    }

    private void initValues() {
        final Random random = new Random();
        boolean hasTrait;
        for ( TraitType type : TraitType.values() ) {
            hasTrait = type == TraitType.Adaptable ? isAdaptable : random.nextInt(2) == 0;
            mTraitMap.put(type, Trait.getInstance(type, hasTrait, mHolder) );
        }
    }

    public final boolean updateTrait(TraitType type, boolean eventSuccessful) {
        return mTraitMap.get(type).change( eventSuccessful, mTraitMap.get(TraitType.Adaptable) );
    }

    public final int getTraitValue(TraitType type) {
        return mTraitMap.get(type).getValue();
    }

    public final boolean hasTrait(TraitType type) {
        return mTraitMap.get(type).hasTrait();
    }

    class ChangeVelocityHolder {
        public final int changeVelocity;

        ChangeVelocityHolder(int changeVelocity) {
            this.changeVelocity = changeVelocity;
        }
    }

    /*
    Adaptable  -> Is adaptable, but adaptability doesn't change
    Chaotic    -> Is adaptable, and adaptability does change
    Static     -> Is NOT adaptable, and doesn't have adaptability
    Unyielding -> Is NOT adaptable, and adaptability doesn't change
    condition ? true : false
     */



}
