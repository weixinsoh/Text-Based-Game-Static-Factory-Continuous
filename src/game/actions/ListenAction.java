package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
import game.scraps.specialscraps.Monologuer;

import java.util.List;

/**
 * Class representing an action to listen.
 *
 */
public class ListenAction extends Action {

    private Monologuer monologuer;

    /**
     * Constructor of the ListenAction class.
     *
     * @param monologuer object to monologue
     */
    public ListenAction(Monologuer monologuer) {
        this.monologuer = monologuer;
    }

    /**
     * Allow the Actor to listen a monologue string.
     * Overrides Action.execute(Actor, GameMap)
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        List<String> monologues = monologuer.allowableMonologues(actor);
        int randNum = Utility.generateRandomInt(0, monologues.size());
        return String.format("%s: \"%s\"", monologuer, monologues.get(randNum));
    }

    /**
     * Returns a description of this listen action to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player listen to Astley. "
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + monologuer;
    }
}
