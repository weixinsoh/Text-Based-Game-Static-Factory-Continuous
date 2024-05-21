package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
import game.scraps.specialscraps.Monologuer;

import java.util.List;

public class ListenAction extends Action {

    private Monologuer monologuer;

    public ListenAction(Monologuer monologuer) {
        this.monologuer = monologuer;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        List<String> monologues = monologuer.allowableMonologues(actor);
        int randNum = Utility.generateRandomInt(0, monologues.size());
        return String.format("%s: \"%s\"", monologuer, monologues.get(randNum));
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + monologuer;
    }
}
