package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class TravelAction extends Action {
    private Location location;
    private String direction;

    public TravelAction(Location location, String direction) {
        this.location = location;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        try {
            new MoveActorAction(location, direction).execute(actor, map);
        } catch (IllegalArgumentException e) {
            return "Teleport failed";
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "teleport to" + direction;
    }
}
