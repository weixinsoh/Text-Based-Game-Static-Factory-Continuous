package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.capabilities.Status;
import game.scraps.specialscraps.Sellable;

/**
 * Class representing large bolt.
 *
 */
public class LargeBolt extends Item implements Sellable {

    private final static int SELL_CREDIT = 25;

    /**
     * Constructor of LargeBolt class.
     *
     */
    public LargeBolt() {
        super("large bolt", '+', true);
    }

    /**
     * Allows the actor with large bolt to sell the large bolt to another actor
     * if that actor has the BUYER status
     * Overrides Item.allowableActions(Actor otherActor, Location location)
     *
     * @param otherActor the other actor that the actor with large bolt is next to
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
     * Sell a large bolt with a certain credit and remove it from the actor's item inventory.
     *
     * @see Sellable#sell(Actor, GameMap)
     * @param otherActor The actor who sold the large bolt.
     * @param map The map the actor is on.
     * @return a string representing the actor sold the large bolt with a certain credit.
     */
    @Override
    public String sell(Actor otherActor, GameMap map) {
        otherActor.addBalance(SELL_CREDIT);
        otherActor.removeItemFromInventory(this);
        return String.format("%s successfully sold Large Bolt for %d credits.", otherActor, SELL_CREDIT);
    }
}
