package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

/**
 * Class representing metal pipe.
 *
 */
public class MetalPipe extends WeaponItem {

    /**
     * Constructor of MetalPipe class.
     *
     */
    public MetalPipe() {
        super("metal pipe", '!', 1, "whacks", 20);
    }

    /**
     * Allow the actor to perform an attack using metal pipe.
     *
     * Overrides WeaponItem.allowableActions(Actor, Location)
     *
     * @see WeaponItem#allowableActions(Actor, Location)
     * @return a list of actions that can be performed by the actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }
}
