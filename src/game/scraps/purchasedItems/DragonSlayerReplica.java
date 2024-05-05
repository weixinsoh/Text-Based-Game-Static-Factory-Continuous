package game.scraps.purchasedItems;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

/**
 * Class representing dragon slayer replica that can be purchased by the computer terminal.
 *
 */
public class DragonSlayerReplica extends WeaponItem implements TradeCapable {

    /**
     * The amount of credits required for a purchase.
     */
    private static final int CREDIT = 100;

    /**
     * The probability of taking credits without printing out from computer terminal.
     *
     */
    private static final double SPECIAL_CASE_CHANCE = 0.5;

    /**
     * Constructor of DragonSlayerReplica class.
     *
     */
    public DragonSlayerReplica() {
        super("Dragon Slayer Replica", 'x', 50, "whacks", 75);
    }

    /**
     * Allow the actor to perform an attack using dragon slayer replica.
     *
     * Overrides WeaponItem.allowableActions(Actor, Location)
     *
     * @see WeaponItem#allowableActions(Actor, Location)
     * @return a list of actions that can be performed by the actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }

    /**
     * Purchase a dragon slayer replica with a certain credit and add it to actor's item inventory with a certain probability.
     *
     * Overrides TradeCapable.trade(Actor)
     *
     * @see TradeCapable#trade(Actor)
     * @param actor The actor who purchases dragon slayer replica.
     * @return a string representing the actor trades the dragon slayer replica with a certain credit.
     */
    @Override
    public String trade(Actor actor) {
        String ret = "";

        if (Payment.makePayment(actor, CREDIT)) {
            if (Math.random() <= SPECIAL_CASE_CHANCE){
                actor.addItemToInventory(this);
                ret += String.format("%s successfully purchased %s for %d credits.", actor, this, CREDIT);
            } else {
                ret += String.format("%d credits are taken from %s, but %s doesn't receive anything in the return!", CREDIT, actor, actor);
            }
        } else {
            ret += String.format("Balance is not sufficient to make the payment (%d < %d). Purchase failed!", actor.getBalance(), CREDIT);
        }
        return ret;
    }
}

