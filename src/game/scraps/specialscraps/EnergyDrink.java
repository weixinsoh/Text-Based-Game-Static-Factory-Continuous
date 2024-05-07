package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

/**
 * Class representing energy drink that can be purchased by the computer terminal.
 *
 */
public class EnergyDrink extends Item implements Consumable, PurchaseCapable {

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
     * Retrieve the actual credits needed when purchasing the item.
     *
     * @return the amount of actual credits
     */
    public int getActualCredit(){
        if (Math.random() <= SPECIAL_CASE_CHANCE)
            return CREDIT * 2;
        else
            return CREDIT;
    }

    /**
     * Allow the actor to consume the energy drink.
     *
     * Overrides Item.allowableActions(Actor)
     *
     * @see Item#allowableActions(Actor)
     * @return a list of actions that can be performed on the energy drink.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Heal the actor after consuming and removes the energy drink from the actor's inventory
     *
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor)
     * @param actor the actor who consumed the healer.
     * @return a string representing the actor consumed the energy drink and effect of the energy drink heals.
     */
    @Override
    public String consumedBy(Actor actor){
        actor.heal(HIT_POINTS);
        actor.removeItemFromInventory(this);
        return String.format("%s drinks Energy Drink. %s feels energised.", actor, actor);
    }

    /**
     * Purchase an energy drink with a certain credit and add it to actor's item inventory
     *
     * Overrides PurchaseCapable.purchase(Actor)
     *
     * @see PurchaseCapable#purchase(Actor)
     * @param actor The actor who purchases energy drink.
     * @return a string representing the actor purchases the energy drink with a certain credit.
     */
    @Override
    public String purchase(Actor actor){
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s for %d credits.", actor, this, getActualCredit());
    }


}