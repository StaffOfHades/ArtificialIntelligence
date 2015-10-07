package ia.actor.common.actor;

import ia.actor.common.state.BodyFunctions;
import ia.actor.common.state.Plan;
import ia.actor.common.type.PersonalityType;
import ia.base.GameEntity;
import ia.characteristics.Attributes;
import ia.characteristics.Stats;
import ia.characteristics.Vector2D;
import ia.message.Perception;
import ia.state.State;
import ia.state.StateManager;
import ia.world_interaction.EffectorListener;
import system.debugging.Log;

import java.util.Random;

/**
 * Default Template. Information about ${PROJECT_NAME} should go here
 * Created by mauriciog on 8/19/15.
 */
public class Actor extends GameEntity implements ActorListener {

    private static final String TAG = "Actor";
    private final StateManager<Actor> mStateManager;

    private final EffectorListener<Actor> mEffector;

    private final Attributes mAttributes;
    private final Inventory mInventory;
    private final Personality mPersonality;

    private boolean inLockedState;

    public static Actor newInstance(EffectorListener<Actor> listener) {
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
        return new Actor(type, listener);
    }

    public static Actor newInstance(Vector2D v2, EffectorListener<Actor> listener) {
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
        return new Actor(type, v2, listener);
    }

    private Actor(PersonalityType type, EffectorListener<Actor> effector) {
        super("Actor " + num);

        mEffector = effector;

        mInventory = Inventory.newInstance();
        mPersonality = Personality.newInstance(type);
        mAttributes = Attributes.newInstance();

        mStateManager = new StateManager<Actor>(this);
        mStateManager.setGlobalState(new BodyFunctions());
        mStateManager.changeState(new Plan());

        inLockedState = true;

        num++;

        ActorControl.getInstance().registerEntity(this);
    }

    private Actor(PersonalityType type, Vector2D v2D, EffectorListener<Actor> effector) {
        super("Actor " + num, v2D);

        mEffector = effector;

        mInventory = Inventory.newInstance();
        mPersonality = Personality.newInstance(type);
        mAttributes = Attributes.newInstance();

        mStateManager = new StateManager<Actor>(this);
        mStateManager.setGlobalState(new BodyFunctions());
        mStateManager.changeState(new Plan());

        inLockedState = true;

        num++;

        ActorControl.getInstance().registerEntity(this);
    }

    public void forceLockedState(boolean inLockedState) {
        Log.w(TAG, toString() + " was forced out of a locked state");
        this.inLockedState = inLockedState;
    }

    @Override
    public void update() {
        mStateManager.update();
    }

    @Override
    public void onPerceptionChanged(Perception perception) {
        Log.d( TAG, "Size of vector list found by perception is " + perception.vectorList.size() );
        for (Vector2D v2 : perception.vectorList) {
            Log.v(TAG, "Found vector " + v2.toString());
        }

        mEffector.onEntityDecision();
    }

    @Override
    public void onChangeState(State<Actor> state) {
        if (inLockedState) {
            Log.i(TAG, "Unable to change to state \"" + state.toString() + "\"; in locked state");
        } else {
            mStateManager.changeState(state);
        }

    }

    @Override
    public void onRevertState() {
        if (inLockedState) {
            Log.i(TAG, "Unable to revert to previous state; in locked state");
        } else {
            mStateManager.revertToPreviousState();
        }
    }

    @Override
    public void onRevertStateBy(int times) {
        if (inLockedState) {
            Log.i(TAG, "Unable to revert to previous state; in locked state");
        } else {
            mStateManager.revertToPreviousStateBy(times);
        }
    }

    @Override
    public boolean onCompareState(State<Actor> state) {
        return mStateManager.isInState(state);
    }

    @Override
    public Attributes getAttributes() {
        return mAttributes;
    }

    @Override
    public Personality getPersonality() {
        return mPersonality;
    }

    @Override
    public Stats getStats() {
        return mStats;
    }

    @Override
    public Inventory getInventory() {
        return mInventory;
    }

    @Override
    public Vector2D getVector2D() {
        return mVector2D;
    }
}
