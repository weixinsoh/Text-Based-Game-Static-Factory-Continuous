package game.actors.creatures;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.capabilities.Status;

/**
 * Class representing Suspicious Astronaut that can be spawned from the crater by its spawner.
 *
 */
public class SuspiciousAstronaut extends Creature {
    private static final int ATTACK_BEHAVIOUR_PRIORITY = 998;
    private static final int WANDER_BEHAVIOUR_PRIORITY = 999;

    private int damage;

    /**
     * Constructor of the Suspicious Astronaut class.
     *
     */
    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", '\u0D9E', 99);
        this.addCapability(Status.HOSTILE_TO_INTERN);
        this.addBehaviour(ATTACK_BEHAVIOUR_PRIORITY, new AttackBehaviour());
        this.addBehaviour(WANDER_BEHAVIOUR_PRIORITY, new WanderBehaviour());
    }

    /**
     * The Suspicious Astronaut can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     * Overrides Actor.allowableActions(Actor, String, GameMap)
     *
     * @see Actor#allowableActions(Actor, String, GameMap)
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return the valid action that can be performed
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(!otherActor.hasCapability(Status.HOSTILE_TO_INTERN)){
            damage = otherActor.getAttributeMaximum(BaseActorAttributes.HEALTH);
        }
        return actions;
    }

    /**
     * Return the intrinsic weapon of the Suspicious Astronaut.
     * Overrides Actor.getIntrinsicWeapon()
     *
     * @see Actor#getIntrinsicWeapon()
     * @return an intrinsic weapon.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(damage, "kills", 100);
    }
}
