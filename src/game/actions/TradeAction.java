package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.purchasedItems.TradeCapable;

/**
 * Class representing an action to trade.
 *
 */
public class TradeAction extends Action {

    /**
     * A trade-capable object for trade action to be performed on.
     */
    public TradeCapable tradeCapable;

    /**
     * Constructor of the TradeAction class.
     *
     * @param tradeCapable object to be trade.
     */
    public TradeAction(TradeCapable tradeCapable){
        this.tradeCapable = tradeCapable;
    }

    /**
     * Allow the Actor to trade something.
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
        return tradeCapable.trade(actor);
    }

    /**
     * Returns a description of this trade suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player purchases energy drink. "
     */
    @Override
    public String menuDescription(Actor actor) {
        return  actor + " purchases " + tradeCapable;
    }
}
