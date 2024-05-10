package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * Class representing toilet paper roll that can be purchased by the computer terminal.
 *
 */
public class ToiletPaperRoll extends Item implements Purchasable {

    private static final int CREDIT = 5;

    private static final int SPECIAL_CASE_CREDIT = 1;

    private static final double SPECIAL_CASE_CHANCE = 0.75;

    /**
     * Constructor of ToiletPaperRoll class.
     *
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
    }

    /**
     * Retrieve the actual credits needed when purchasing the item.
     *
     * @return the amount of actual credits
     */
    public int getActualCredit(){
        if (Math.random() <= SPECIAL_CASE_CHANCE)
            return SPECIAL_CASE_CREDIT;
        else
            return CREDIT;
    }

    /**
     * Purchase a toilet paper roll with a certain credit and add it to actor's item inventory
     * Overrides PurchaseCapable.purchase(Actor)
     *
     * @see Purchasable#purchase(Actor)
     * @param actor The actor who purchases toilet paper roll.
     * @return a string representing the actor purchases the toilet paper roll with a certain credit.
     */
    @Override
    public String purchase(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s for %d credits.", actor, this, getActualCredit());
    }
}
