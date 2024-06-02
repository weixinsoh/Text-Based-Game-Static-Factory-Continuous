package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.capabilities.Status;

/**
 * Class representing a metal pipe.
 *
 */
public class MetalPipe extends WeaponItem implements Sellable {
    private static final int SELL_CREDIT = 35;

    /**
     * Constructor of MetalPipe class.
     *
     */
    public MetalPipe() {
        super("metal pipe", '!', 1, "whacks", 20);
    }

    /**
     * Allow the actor to perform an attack using metal pipe.
     * Overrides WeaponItem.allowableActions(Actor, Location)
     *
     * @see WeaponItem#allowableActions(Actor, Location)
     * @return a list of actions that can be performed by the actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE_TO_INTERN))
            actions.add(new AttackAction(otherActor, location.toString(), this));

        if(otherActor.hasCapability(Status.BUYER)){
            actions.add(new SellAction(this));
        }

        return actions;
    }

    /**
     * Sell a metal pipe with a certain credit and remove it from the actor's item inventory.
     *
     * @see Sellable#sell(Actor, GameMap)
     * @param otherActor The actor who sold the metal pipe.
     * @param map The map the actor is on.
     * @return a string representing the actor sold the metal pipe with a certain credit.
     */
    @Override
    public String sell(Actor otherActor, GameMap map) {
        otherActor.addBalance(SELL_CREDIT);
        otherActor.removeItemFromInventory(this);
        return String.format("%s successfully sold Metal Pipe for %d credits.", otherActor, SELL_CREDIT);
    }
}
