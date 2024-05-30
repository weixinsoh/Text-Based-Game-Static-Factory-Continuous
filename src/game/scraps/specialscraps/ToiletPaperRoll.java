package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.capabilities.Status;
import game.scraps.Sellable;

/**
 * Class representing toilet paper roll that can be purchased by the computer terminal.
 *
 */
public class ToiletPaperRoll extends Item implements Purchasable, Sellable {

    private static final int CREDIT = 5;

    private static final int SPECIAL_CASE_CREDIT = 1;

    private static final double SPECIAL_CASE_CHANCE = 0.75;

    private final int actual_credit;

    /**
     * Constructor of ToiletPaperRoll class.
     *
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
        if (Math.random() <= SPECIAL_CASE_CHANCE)
            actual_credit = SPECIAL_CASE_CREDIT;
        else
            actual_credit = CREDIT;
    }

    /**
     * Retrieve the actual credits needed when purchasing the item.
     *
     * @return the amount of actual credits
     */
    public int getActualCredit(){
        return actual_credit;
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

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.BUYER)){
            actions.add(new SellAction(this));
        }
        return actions;
    }


    @Override
    public String sell(Actor otherActor) {
        if (Math.random() <= 0.5){
            otherActor.addBalance(1);   //50% chance of adding 1 credit
            otherActor.removeItemFromInventory(this);
            return otherActor.toString() +  " successfully sold Toilet Paper Roll for 1 credit.";
        } else {
            otherActor.hurt(otherActor.getAttribute(BaseActorAttributes.HEALTH));
            otherActor.removeItemFromInventory(this);
            return "The humanoid figure attacked the player"; //PLACEHOLDER TEXT
        }
    }
}
