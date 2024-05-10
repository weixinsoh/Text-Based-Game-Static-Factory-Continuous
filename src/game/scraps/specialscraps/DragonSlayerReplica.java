package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.capabilities.Status;

/**
 * Class representing dragon slayer replica that can be purchased by the computer terminal.
 *
 */
public class DragonSlayerReplica extends WeaponItem implements Purchasable {

    private static final int CREDIT = 100;

    private static final double SPECIAL_CASE_CHANCE = 0.5;

    /**
     * Constructor of DragonSlayerReplica class.
     *
     */
    public DragonSlayerReplica() {
        super("Dragon Slayer Replica", 'x', 50, "whacks", 75);
    }

    /**
     * Retrieve the actual credits needed when purchasing the item.
     *
     * @return the amount of actual credits
     */
    public int getActualCredit(){
        return CREDIT;
    }

    /**
     * Allow the actor to perform an attack using dragon slayer replica.
     * Overrides WeaponItem.allowableActions(Actor, Location)
     *
     * @see WeaponItem#allowableActions(Actor, Location)
     * @return a list of actions that can be performed on the dragon slayer replica.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_INTERN))
            actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }

    /**
     * Purchase a dragon slayer replica with a certain credit and add it to actor's item inventory with a certain probability.
     * Overrides PurchaseCapable.purchase(Actor)
     *
     * @see Purchasable#purchase(Actor)
     * @param actor The actor who purchases dragon slayer replica.
     * @return a string representing the actor purchases the dragon slayer replica with a certain credit.
     */
    @Override
    public String purchase(Actor actor) {
        if (Math.random() <= SPECIAL_CASE_CHANCE) {
            return String.format("%d credits are taken from %s, but %s doesn't receive anything in the return!", CREDIT, actor, actor);
        } else {
            actor.addItemToInventory(this);
            return String.format("%s successfully purchased %s for %d credits.", actor, this, CREDIT);
        }
    }
}

