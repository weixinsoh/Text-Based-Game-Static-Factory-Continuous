package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * Class representing toilet paper roll that can be purchased by the computer terminal.
 *
 */
public class ToiletPaperRoll extends Item implements TradeCapable{

    /**
     * The amount of credits required for a standard purchase.
     */
    private static final int CREDIT = 5;

    /**
     * The amount of credits required for a special case purchase.
     */
    private static final int SPECIAL_CASE_CREDIT = 1;

    /**
     * The probability of encountering a special case purchase scenario.
     *
     */
    private static final double SPECIAL_CASE_CHANCE = 0.75;

    /**
     * Constructor of ToiletPaperRoll class.
     *
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
    }

    /**
     * Purchase a toilet paper roll with a certain credit and add it to actor's item inventory
     *
     * Overrides TradeCapable.trade(Actor)
     *
     * @see TradeCapable#trade(Actor)
     * @param actor The actor who purchases toilet paper roll.
     * @return a string representing the actor trades the toilet paper roll with a certain credit.
     */
    @Override
    public String trade(Actor actor) {
        String ret = "";
        int newCredit = CREDIT;

        if (Math.random() <= SPECIAL_CASE_CHANCE)
            newCredit = SPECIAL_CASE_CREDIT;

        if (Payment.makePayment(actor,newCredit)){
            actor.addItemToInventory(this);
            ret += String.format("%s successfully purchased %s for %d credits.", actor, this, newCredit);
        } else {
            ret += String.format("Balance is not sufficient to make the payment (%d < %d). Purchase failed!", actor.getBalance(), CREDIT);
        }
        return ret;
    }
}
