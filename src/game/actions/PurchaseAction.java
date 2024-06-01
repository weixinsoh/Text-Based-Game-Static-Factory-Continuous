package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.specialscraps.Purchasable;

/**
 * Class representing an action to purchase.
 *
 */
public class PurchaseAction extends Action {

    private Purchasable purchasedItem;

    /**
     * Constructor of the PurchaseAction class.
     *
     * @param purchasedItem object to be purchased.
     */
    public PurchaseAction(Purchasable purchasedItem){
        this.purchasedItem = purchasedItem;
    }

    /**
     * Allow the Actor to purchase something if the actor has sufficient balance.
     * Overrides Action.execute(Actor, GameMap)
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int creditRequired = this.purchasedItem.getActualCredit();
        int balance = actor.getBalance();
        if (balance >= creditRequired){
            actor.deductBalance(creditRequired);
            return purchasedItem.purchase(actor);
        } else
            return String.format("Balance is not sufficient to make the payment (%d < %d). Purchase failed!", balance, creditRequired);
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
