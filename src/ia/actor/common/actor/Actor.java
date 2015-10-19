package ia.actor.common.actor;

import ia.actor.common.state.BodyFunctions;
import ia.actor.common.state.Plan;
import ia.actor.common.type.PersonalityType;
import ia.base.GameEntity;
import ia.characteristics.Stats;
import ia.characteristics.Vector2D;
import ia.message.Perception;
import ia.state.State;
import ia.state.StateManager;
import ia.world_interaction.CascadeDeleteListener;
import ia.world_interaction.EffectorListener;
import system.debugging.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Default Template. Information about ${PROJECT_NAME} should go here
 * Created by mauriciog on 8/19/15.
 */
public class Actor extends GameEntity implements ActorListener {

    private static final String TAG = "Actor";

    private final Attributes mAttributes = Attributes.newInstance();;
    private final Inventory mInventory = Inventory.newInstance();
    private final Personality mPersonality;

    private StateManager<Actor> mStateManager;
    private EffectorListener<Actor> mEffector;
    private CascadeDeleteListener<Actor> mDeleteListener;

    private boolean inLockedState;

    public static Actor newInstance(EffectorListener<Actor> listener) {
        return new Actor(nextPersonality(), listener);
    }

    public static Actor newInstance(Vector2D v2, EffectorListener<Actor> listener) {
        return new Actor(nextPersonality(), v2, listener);
    }

    private static PersonalityType nextPersonality() {
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
        return type;
    }

    private Actor(PersonalityType type, EffectorListener<Actor> effector) {
        super("Actor " + num);
        num++;
        ActorControl.getInstance().registerEntity(this);

        mEffector = effector;

        mPersonality = Personality.newInstance(type);

        mAttributes.changeStrength(0, mPersonality);
        mStats.setMaxHealth(mAttributes.getStrength() * 2);

        mStateManager = new StateManager<>(this);
        mStateManager.setGlobalState( BodyFunctions.newInstance() );
        mStateManager.changeState( Plan.newInstance() );
    }

    private Actor(PersonalityType type, Vector2D v2D, EffectorListener<Actor> effector) {
        super("Actor " + num, v2D);
        num++;
        ActorControl.getInstance().registerEntity(this);

        mEffector = effector;

        mPersonality = Personality.newInstance(type);

        mAttributes.changeStrength(0, mPersonality);
        mStats.setMaxHealth(mAttributes.getStrength() * 2);

        mStateManager = new StateManager<>(this);
        mStateManager.setGlobalState( BodyFunctions.newInstance() );
        mStateManager.changeState( Plan.newInstance() );
    }

    public void forceLockedState(boolean inLockedState) {
        Log.w(TAG, toString() + " was forced " + (inLockedState ? "into" : "out of") + "  a locked state");
        this.inLockedState = inLockedState;
    }

    @Override
    public void update() {
        mStateManager.update();
    }

    @Override
    public void delete() {
        mStateManager.delete();
        mStateManager = null;
        ActorControl.getInstance().removeEntity(this);
        mStats.delete();
        mDeleteListener.onCascadeDelete();
        mDeleteListener = null;
    }

    @Override
    protected Stats initStats() {
        return Stats.newInstance(this);
    }

    @Override
    public Map<String, String> getEntityInfo() {
        final Map<String, String> map = new HashMap<>();
        /*map.put("health", Integer.toString(mStats.getCurrentHealth()));
        map.put("hunger", Integer.toString(mAttributes.hunger));*/
        map.put("gold", Integer.toString(mInventory.resource));
        map.put("strenth", Integer.toString(mAttributes.getStrength()));
        return map;
    }

    @Override
    public void setCascadeDeleteListener(CascadeDeleteListener<Actor> listener) {
        mDeleteListener = listener;
    }

    @Override
    public void onPerceptionChanged(Perception perception) {
        Log.d( TAG, "Size of vector list found by perception is " + perception.vectorList.size() );
        for (Vector2D v2 : perception.vectorList) {
            Log.v(TAG, toString() + " found vector " + v2.toString());
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
            Log.i(TAG, toString()  + " unable to revert to previous state; in locked state");
        } else {
            mStateManager.revertToPreviousState();
        }
    }

    @Override
    public void onRevertStateBy(int times) {
        if (inLockedState) {
            Log.i(TAG, toString() + " unable to revert to previous state; in locked state");
        } else {
            mStateManager.revertToPreviousStateBy(times);
        }
    }

    @Override
    public boolean onCompareState(Class<? extends State<Actor>> stateCLass) {
        return mStateManager.isInState(stateCLass);
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

    @Override
    public void onDeleteChain(CascadeDeleteListener<Actor> object) {
        mEffector.onDeleteChain(object);
        mEffector = null;
    }
}
