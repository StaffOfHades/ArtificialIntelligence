package ia.actor.common.actor;

import ia.actor.common.state.Planning;
import ia.actor.common.type.PersonalityType;
import ia.base.GameEntity;
import ia.characteristics.Attributes;
import ia.characteristics.Stats;
import ia.characteristics.Vector2D;
import ia.state.State;
import ia.state.StateManager;
import ia.world_interaction.EffectorListener;
import ia.world_interaction.PercipientListener;

import java.util.Random;

/**
 * Default Template. Information about ${PROJECT_NAME} should go here
 * Created by mauriciog on 8/19/15.
 */
public class Actor extends GameEntity implements PercipientListener<Actor> {

    private final StateManager<Actor> mStateManager;

    private final EffectorListener<Actor> mEffector;

    public final Attributes attributes;
    public final Personality personality;
    public final Stats stats;
    public final Vector2D vector2d;
    public int gold;
    public int hunger;

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

    private Actor(PersonalityType type, Vector2D v2D, EffectorListener<Actor> effector) {
        super("Actor " + num);

        mEffector = effector;
        mStateManager = new StateManager<Actor>(this);
        mStateManager.changeState(new Planning());

        vector2d = v2D;
        personality = Personality.newInstance(type);
        stats = Stats.newInstance();
        attributes = Attributes.newInstance();

        gold = 0;

        num++;

        ActorControl.getInstance().registerEntity(this);
    }

    @Override
    public void onPerceptionChanged() {
        // Change current state
        mEffector.onEntityDecision();
    }

    @Override
    public void onChangeState(State<Actor> state) {
        mStateManager.changeState(state);
    }

    @Override
    public void onRevertState() {
        mStateManager.revertToPreviousState();
    }

    @Override
    public boolean onCompareState(State<Actor> state) {
        return mStateManager.isInState(state);
    }


    @Override
    public void update() {
        mStateManager.update();
    }
}
