package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class TravelAction extends Action {

    private Location travelToLocation;

    private String mapName;

    public TravelAction(Location travelToLocation, String mapName) {
        this.travelToLocation = travelToLocation;
        this.mapName = mapName;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        try {
            new MoveActorAction(travelToLocation, mapName).execute(actor, map);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return actor + " travel to " + mapName;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travel to " + mapName;
    }
}
