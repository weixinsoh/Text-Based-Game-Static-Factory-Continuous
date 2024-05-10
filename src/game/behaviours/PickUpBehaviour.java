package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
import java.util.ArrayList;

/**
 * Class representing the behaviour to pick up portable items.
 *
 */
public class PickUpBehaviour implements Behaviour {

    /**
     * Returns a PickUpAction to pick up the portable items at the location the actor standing at.
     * If no item can be picked up, it returns null.
     *
     * Overrides Behaviour.getAction(Actor, GameMap)
     *
     * @see Behaviour#getAction(Actor, GameMap)
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if the following actor or it dies.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        ArrayList<Action> actions = new ArrayList<>();
        for (Item item: map.locationOf(actor).getItems()) {
            Action action = item.getPickUpAction(actor);
            if (action != null) {
                actions.add(action);
            }
        }

        if (!actions.isEmpty()) {
            return actions.get(Utility.generateRandomInt(0, actions.size()));
        }
        else {
            return null;
        }
    }
}
