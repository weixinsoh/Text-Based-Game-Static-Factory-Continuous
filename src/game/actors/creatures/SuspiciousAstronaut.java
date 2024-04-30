package game.actors.creatures;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttribute;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.capabilities.Status;

public class SuspiciousAstronaut extends Creature {
    private static final int ATTACK_BEHAVIOUR_PRIORITY = 998;
    private static final int WANDER_BEHAVIOUR_PRIORITY = 999;

    private int damage;

    /**
     * Constructor of the Creature class.
     *
     */
    public SuspiciousAstronaut() {
        super("SuspiciousAstronaut", 'ඞ', 99);
        this.addCapability(Status.HOSTILE_TO_INTERN);
        this.addBehaviour(ATTACK_BEHAVIOUR_PRIORITY, new AttackBehaviour());
        this.addBehaviour(WANDER_BEHAVIOUR_PRIORITY, new WanderBehaviour());
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            damage = otherActor.getAttributeMaximum(BaseActorAttributes.HEALTH);
        }
        return actions;
    }

    @Override
    public Creature spawn() {
        return null;
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(damage, "kills", 100);
    }
}
