package ia.characteristics;

import ia.base.GameEntity;
import system.debugging.Log;

/**
 * Created by mauriciog on 8/19/15.
 */
public class Stats {

    private static final String TAG = "Stats";
    private GameEntity mParent;
    private int
            mMaxHealth,
            mCurrentHealth;



    public static Stats newInstance(GameEntity parent) {
        return new Stats(parent);
    }

    private Stats(GameEntity parent) {
        mParent = parent;
        mCurrentHealth = mMaxHealth = 1;
    }

    public final void setMaxHealth(int maxHealth) {
        mCurrentHealth = mMaxHealth = maxHealth;
        Log.d(TAG, "Current/Max health is " + mMaxHealth);
    }

    public final int getMaxHealth() {
        return mMaxHealth;
    }

    public final int getCurrentHealth() {
        return mCurrentHealth;
    }

    public final void adjustHealth(int adjustment) {
        mCurrentHealth += adjustment;
        if (mCurrentHealth > mMaxHealth)
            mCurrentHealth = mMaxHealth;
        if (mCurrentHealth <= 0)
            mParent.delete();
        mParent = null;
    }
}
