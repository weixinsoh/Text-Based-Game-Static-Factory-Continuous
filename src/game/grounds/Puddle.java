package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.scraps.specialscraps.Consumable;

/**
 * Class representing a puddle that extends from Ground and implements Consumable
 * It can be consumed by an Intern standing on the puddle
 * It increases the Intern's maximum health by one.
 */
public class Puddle extends Ground implements Consumable {

    private static final int PUDDLE_HEALTH = 1;

    /**
     * Constructor of the Puddle class.
     */
    public Puddle() {
        super('~');
    }

    /**
     * Increases the Actor's maximum health by 1
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor, GameMap)
     * @param actor the actor who consumes the Puddle
     * @return a string representing the actor has consumed the Puddle and the amount of health the puddle increases the actor's maximum health
     */
    public String consumedBy(Actor actor, GameMap map){
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, PUDDLE_HEALTH);
        return String.format("%s consumes %s and maximum health increase by %d points. ", actor, this, PUDDLE_HEALTH);
    }

    /**
     * Allow the actor to consume the Puddle
     * Overrides Ground.allowableActions(Actor, Location, String)
     *
     * @see Ground#allowableActions(Actor, Location, String)
     * @return a list of actions that can be performed on the Puddle
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (direction.isEmpty()){
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }

    /**
     * The Puddle as a string
     *
     * @return the Puddle represented as a string
     */
    @Override
    public String toString(){
        return "Puddle";
    }

}
