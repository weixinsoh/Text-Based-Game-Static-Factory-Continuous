package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.capabilities.Status;

/**
 * Class representing toilet paper roll that can be purchased by the computer terminal.
 *
 */
public class ToiletPaperRoll extends Item implements Purchasable, Sellable {

    private static final int PURCHASE_CREDIT = 5;

    private static final int PURCHASE_SPECIAL_CASE_CREDIT = 1;

    private static final double PURCHASE_SPECIAL_CASE_CHANCE = 0.75;

    private final int actualPurchaseCredit;

    private static final double SELL_SPECIAL_CASE_CHANCE = 0.5;

    private static final int SELL_CREDIT = 5;


    /**
     * Constructor of ToiletPaperRoll class.
     *
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
        if (Math.random() <= PURCHASE_SPECIAL_CASE_CHANCE)
            actualPurchaseCredit = PURCHASE_SPECIAL_CASE_CREDIT;
        else
            actualPurchaseCredit = PURCHASE_CREDIT;
    }

    /**
     * Retrieve the actual credits needed when purchasing the item.
     *
     * @return the amount of actual credits
     */
    public int getActualCredit(){
        return actualPurchaseCredit;
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

    /**
     * Allows the actor with a toilet paper roll to sell the toilet paper roll to another actor
     * if that actor has the BUYER status
     * Overrides Item.allowableActions(Actor otherActor, Location location)
     *
     * @param otherActor the other actor that the actor with toilet paper roll is next to
     * @param location the location of the other actor
     * @return a list of allowable actions that can be taken
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.BUYER)){
            actions.add(new SellAction(this));
        }
        return actions;
    }

    /**
     * Sell a toilet paper roll with a certain credit, with a chance that the actor will be killed instantly and remove it from the actor's item inventory.
     *
     * @see Sellable#sell(Actor, GameMap)
     * @param otherActor The actor who sold the toilet paper roll.
     * @param map The map the actor is on.
     * @return a string representing the actor sold the toilet paper roll with a certain credit or that they have been killed (are unconscious).
     */
    @Override
    public String sell(Actor otherActor, GameMap map) {
        otherActor.removeItemFromInventory(this);
        if (Math.random() <= SELL_SPECIAL_CASE_CHANCE){
            return otherActor.unconscious(map);
        } else {
            otherActor.addBalance(SELL_CREDIT);   //50% chance of adding 1 credit
            return otherActor +  " successfully sold Toilet Paper Roll for 1 credit.";
        }
    }
}
