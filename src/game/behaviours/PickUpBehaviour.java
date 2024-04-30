package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
import java.util.ArrayList;

public class PickUpBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {

        ArrayList<Action> actions = new ArrayList<>();
        for (Item item: map.locationOf(actor).getItems()) {
            actions.add(new PickUpAction(item));
        }

        if (!actions.isEmpty()) {
            return actions.get(Utility.generateRandomInt(0, actions.size()));
        }
        else {
            return null;
        }
    }
}
