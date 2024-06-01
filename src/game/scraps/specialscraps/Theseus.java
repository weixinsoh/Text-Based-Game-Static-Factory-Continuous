package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.actions.TravelAction;

/**
 * Class representing the THESEUS that can teleport the actor to a random location within the current map.
 */
public class Theseus extends Item implements Purchasable{
    private static final int CREDIT = 100;

    /***
     * Constructor of the THESEUS.
     */
    public Theseus() {
        super("THESEUS", '^', true);
    }

    /**
     * Purchase an THESEUS with a certain credit and add it to actor's item inventory
     * Overrides Purchasable.purchase(Actor)
     *
     * @param actor The actor who purchases the THESEUS.
     * @return a string representing the actor purchases the THESEUS with a certain credit.
     */
    @Override
    public String purchase(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s for %d credits.", actor, this, CREDIT);
    }

    /**
     * Retrieve the actual credits needed when purchasing the item.
     *
     * @return the amount of actual credits
     */
    @Override
    public int getActualCredit() {
        return CREDIT;
    }

    /**
     * Allow the actor to be teleported to a random location within the current map.
     * Overrides Item.allowableActions(Actor)
     *
     * @see Item#allowableActions(Actor)
     * @return a list of actions that can be performed on the THESEUS.
     */
    @Override
    public ActionList allowableActions(Location location){
        ActionList actions = new ActionList();
        int x = Utility.generateRandomInt(location.map().getXRange().min(), location.map().getXRange().max());
        int y = Utility.generateRandomInt(location.map().getYRange().min(), location.map().getYRange().max());
        Location newLocation = location.map().at(x, y);
        actions.add(new TravelAction(newLocation, "with THESEUS"));
        return actions;
    }
}
