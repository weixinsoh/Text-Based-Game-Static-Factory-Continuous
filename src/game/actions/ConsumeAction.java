package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.consumable.Consumable;

/**
 * Class representing an action to consume.
 *
 */
public class ConsumeAction extends Action {
    Consumable consumable;

    /**
     * Constructor of the ConsumeAction class.
     *
     * @param consumable substance to be consumed.
     */
    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * Allow the Actor to consume something.
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
        return consumable.consumedBy(actor);
    }

    /**
     * Returns a description of this consume suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player consumes small fruit. "
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}
