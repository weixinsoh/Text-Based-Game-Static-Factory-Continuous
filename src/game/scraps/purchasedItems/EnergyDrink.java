package game.scraps.purchasedItems;

import edu.monash.fit2099.engine.actors.Actor;
import game.consumable.Consumable;
import game.consumable.ConsumableItem;

/**
 * Class representing energy drink that can be purchased by the computer terminal.
 *
 */
public class EnergyDrink extends ConsumableItem implements TradeCapable {

    /**
     * The amount of credits required for a standard purchase.
     */
    private static final int CREDIT = 10;

    /**
     * The amount of points it can heal after consuming by the actor.
     *
     */
    private static final int HIT_POINTS = 1;

    /**
     * The probability of encountering a special case purchase scenario.
     *
     */
    private static final double SPECIAL_CASE_CHANCE = 0.2;

    /**
     * Constructor of EnergyDrink class.
     *
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true);
    }

    /**
     * Heal the actor after consuming.
     *
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor)
     * @param actor the actor who consumed the healer.
     * @return a string representing the actor consumed the energy drink and the energy drink heals him by point(s).
     */
    @Override
    public String consumedBy(Actor actor){
        actor.heal(HIT_POINTS);
        return String.format("%s drinks Energy Drink. %s feels energised.", actor, actor);
    }

    /**
     * Purchase an energy drink with a certain credit and add it to actor's item inventory
     *
     * Overrides TradeCapable.trade(Actor)
     *
     * @see TradeCapable#trade(Actor)
     * @param actor The actor who purchases energy drink.
     * @return a string representing the actor trades the energy drink with a certain credit.
     */
    @Override
    public String trade(Actor actor){
        String ret = "";

        int newCredit = CREDIT;

        if (Math.random() <= SPECIAL_CASE_CHANCE)
            newCredit = CREDIT * 2;

        if (Payment.makePayment(actor,newCredit)){
            actor.addItemToInventory(this);
            ret += String.format("%s successfully purchased %s for %d credits.", actor, this, newCredit);
        } else {
            ret += String.format("Balance is not sufficient to make the payment (%d < %d). Purchase failed!", actor.getBalance(), CREDIT);
        }
        return ret;
    }


}