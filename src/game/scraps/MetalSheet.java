package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.capabilities.Status;

/**
 * Class representing metal sheet.
 *
 */
public class MetalSheet extends Item implements Sellable{

    private static final double SELL_SPECIAL_CASE_CHANCE = 0.6;

    private static final int SELL_SPECIAL_CASE_CREDIT = 10;

    private static final int SELL_CREDIT = 20;

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
    public String sell(Actor otherActor, GameMap map) {
        otherActor.removeItemFromInventory(this);
        if (Math.random() <= SELL_SPECIAL_CASE_CHANCE){
            otherActor.addBalance(SELL_SPECIAL_CASE_CREDIT);
            return String.format("%s successfully sold Metal Sheet for %d credits.", otherActor, SELL_SPECIAL_CASE_CREDIT);
        } else {
            otherActor.addBalance(SELL_CREDIT);
            return String.format("%s successfully sold Metal Sheet for %d credits.", otherActor, SELL_CREDIT);
        }
    }
}
