package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.specialscraps.PurchaseCapable;

/**
 * Class representing an action to purchase.
 *
 */
public class PurchaseAction extends Action {

    /**
     * A purchasable object for purchase action to be performed on.
     */
    public PurchaseCapable purchasedItem;

    /**
     * Constructor of the PurchaseAction class.
     *
     * @param purchasedItem object to be purchase.
     */
    public PurchaseAction(PurchaseCapable purchasedItem){
        this.purchasedItem = purchasedItem;
    }

    /**
     * Allow the Actor to purchase something if the actor has sufficient balance.
     *
     * Overrides Action.execute(Actor, GameMap)
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int credit = this.purchasedItem.getActualCredit();
        if (actor.getBalance() >= credit){
            actor.deductBalance(credit);
            return purchasedItem.purchase(actor);
        } else
            return String.format("Balance is not sufficient to make the payment (%d < %d). Purchase failed!", actor.getBalance(), credit);

    }

    /**
     * Returns a description of this purchase action to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player purchases energy drink. "
     */
    @Override
    public String menuDescription(Actor actor) {
        return  actor + " purchases " + purchasedItem;
    }
}
