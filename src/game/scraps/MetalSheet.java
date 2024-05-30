package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.capabilities.Status;

/**
 * Class representing metal sheet.
 *
 */
public class MetalSheet extends Item implements Sellable{
    /**
     * Constructor of MetalSheet class.
     *
     */
    public MetalSheet() {
        super("metal sheet", '%', true);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.BUYER)){
            actions.add(new SellAction(this));
        }
        return actions;
    }

    @Override
    public String sell(Actor otherActor) {
        if (Math.random() <= 0.6){
            otherActor.addBalance(10);
            otherActor.removeItemFromInventory(this);
            return otherActor.toString() +  " successfully sold Metal Sheet for 10 credits.";
        } else {
            otherActor.addBalance(20);
            otherActor.removeItemFromInventory(this);
            return otherActor.toString() +  " successfully sold Metal Sheet for 20 credits.";
        }
    }
}
