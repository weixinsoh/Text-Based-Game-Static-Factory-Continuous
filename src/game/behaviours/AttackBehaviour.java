package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.capabilities.Status;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class representing the behaviour to attack other actors.
 *
 */
public class AttackBehaviour implements Behaviour {
    private final Random random = new Random();

    /**
     * Returns a AttackAction to attack other actor that is not hostile to intern, if there is an actor in the surroundings.
     * If no actor is in the surroundings, returns null.
     *
     * Overrides Behaviour.getAction(Actor, GameMap)
     *
     * @see Behaviour#getAction(Actor, GameMap)
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if no actor is in the surroundings.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        ArrayList<Action> actions = new ArrayList<>();

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = map.getActorAt(destination);
                if (!target.hasCapability(Status.HOSTILE_TO_INTERN)) {
                    actions.add(new AttackAction(target, exit.getName()));
                }
            }
        }

        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        else {
            return null;
        }
    }
}
