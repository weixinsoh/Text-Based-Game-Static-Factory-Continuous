package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.positions.Ground;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.consumable.Consumable;

import static edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations.INCREASE;
import static edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes.HEALTH;

/**
 * Class representing puddle.
 */
public class Puddle extends Ground implements Consumable {

    private static final int PUDDLE_HEALTH = 1;

    /**
     * Constructor of the Puddle class.
     */
    public Puddle() {
        super('~');
    }

    public String consumedBy(Actor actor){
        actor.modifyAttribute(HEALTH, INCREASE, PUDDLE_HEALTH);
        return "Intern slurps from puddle and increase health by 1.";
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    @Override
    public String toString(){
        return "Puddle";
    }

}
