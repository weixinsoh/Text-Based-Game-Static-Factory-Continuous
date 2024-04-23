package game.actors.creatures;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.capabilities.Status;
import game.behaviours.WanderBehaviour;

/**
 * Class representing huntsman spider that can be spawned by the crater.
 *
 */
public class HuntsmanSpider extends Creature {

    private static final int WANDER_BEHAVIOUR_PRIORITY = 999;
    private static final int ATTACK_BEHAVIOUR_PRIORITY = 0;
    private static final double SPAWN_PROBABILITY = 0.05;

    /**
     * Constructor of the HuntsmanSpider class.
     *
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.addBehaviour(WANDER_BEHAVIOUR_PRIORITY, new WanderBehaviour());
        this.addBehaviour(ATTACK_BEHAVIOUR_PRIORITY, new AttackBehaviour());
        this.addCapability(Status.HOSTILE_TO_INTERN);
    }

    /**
     * The huntsman spider can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * Overrides Actor.allowableActions(Actor, String, GameMap)
     *
     * @see Actor#allowableActions(Actor, String, GameMap)
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Return the intrinsic weapon of the huntsman spider.
     *
     * Overrides Actor.getIntrinsicWeapon()
     *
     * @see Actor#getIntrinsicWeapon()
     * @return an intrinsic weapon.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "long legs", 25);
    }

    /**
     * Allow a huntsman spider to be spawned by the Crater.
     *
     * Overrides Creature.spawn()
     *
     * @return a huntsman spider to be added to map if probability is met, otherwise null.
     */
    @Override
    public Creature spawn() {
        if (Math.random() <= SPAWN_PROBABILITY) {
            return new HuntsmanSpider();
        }
        return null;
    }

}
