package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.specialscraps.Sellable;
/**
 * Class representing a sell action.
 *
 */
public class SellAction extends Action {

    private Sellable sellableItem;

    /**
     * Constructor of the SellAction class.
     *
     * @param sellableItem object to be sold.
     */
    public SellAction(Sellable sellableItem){
        this.sellableItem = sellableItem;
    }

    /**
     * Allow the Actor to sell something if the appropriate item is in their inventory.
     * Overrides Action.execute(Actor, GameMap)
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return sellableItem.sell(actor, map);
    }

    /**
     * Returns a description of this sell action to display in the menu.
     *
     * @param actor The actor performing the sell action.
     * @return a String, e.g. "Player sells Toilet Paper Roll. "
     */
    @Override
    public String menuDescription(Actor actor){
        return  actor + " sells " + sellableItem;
    }
}
