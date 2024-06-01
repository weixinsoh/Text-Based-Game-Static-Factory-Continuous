package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Class representing the action to teleport to a new location.
 */
public class TravelAction extends Action {
    private Location location;
    private String direction;

    /**
     * Constructor of the TravelAction.
     * @param location the new location to teleport the actor to.
     * @param direction the direction of the new location (eg. to Polymorphia).
     */
    public TravelAction(Location location, String direction) {
        this.location = location;
        this.direction = direction;
    }

    /**
     * Teleport the actor to the new location.
     * Overrides Action.execute(Actor, GameMap)
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor to be teleported.
     * @param map The map the actor is on.
     * @return a String to announce the teleport is success or failed.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        try {
            new MoveActorAction(location, direction).execute(actor, map);
        } catch (IllegalArgumentException e) {
            return "Teleport failed";
        }
        return menuDescription(actor);
    }

    /**
     * Returns a description of this teleport action to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player teleport to Polymorphia. "
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleport " + direction;
    }
}
