package game.actors.creatures;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * Abstract base class representing creature that can be spawned by the crater.
 *
 */
public abstract class Creature extends Actor {

    private Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor of the Creature class.
     *
     * @param name        the name of the Creature
     * @param displayChar the character that will represent the Creature in the display
     * @param hitPoints   the Creature's starting hit points
     */
    public Creature(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    /**
     * Add a behaviour to the TreeMap behaviours with given key.
     *
     * @param key An integer to indicate the priority of the behaviour.
     * @param behaviour The behaviour to add to.
     */
    public void addBehaviour(int key, Behaviour behaviour) {
        behaviours.put(key, behaviour);
    }

    /**
     * At each turn, select a valid action to perform.
     *
     *
     * Overrides Actor.playTurn(ActionList, Action, GameMap, Display)
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * Allow a new creature to be spawned by the Crater.
     *
     * @return a Creature to be added to map.
     */
    public abstract Creature spawn();
}
