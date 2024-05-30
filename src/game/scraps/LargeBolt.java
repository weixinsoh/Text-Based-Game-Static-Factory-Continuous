package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.capabilities.Status;

/**
 * Class representing large bolt.
 *
 */
public class LargeBolt extends Item implements Sellable{
    /**
     * Constructor of LargeBolt class.
     *
     */
    public LargeBolt() {
        super("large bolt", '+', true);
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
        otherActor.addBalance(25);
        otherActor.removeItemFromInventory(this);
        return otherActor.toString() +  " successfully sold Large Bolt for 25 credits.";
    }
}
