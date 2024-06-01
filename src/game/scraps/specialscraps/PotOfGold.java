package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.capabilities.Status;
import game.scraps.Sellable;

/**
 * Class that represents a Pot of Gold that can be used by the intern to add 10 gold to the Intern's balance
 *
 */
public class PotOfGold extends Item implements Consumable, Sellable {

    private static final int POT_OF_GOLD_BALANCE = 10;

    private static final double SELL_SPECIAL_CASE_CHANCE = 0.25;

    private static final int SELL_CREDIT = 500;

    /**
     * Constructor of the PotOfGold class.
     */
    public PotOfGold() {
        super("Pot of Gold", '$', true);
    }

    /**
     * Adds the POT_OF_GOLD_BALANCE to the actor's balance and
     * Removes the Pot of Gold from the actor's inventory
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor)
     * @param actor the actor who consumes the Pot of Gold
     * @return a string representing the actor has consumed the Pot of Gold and the amount the Pot of Gold adds to the actor's balance
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.addBalance(POT_OF_GOLD_BALANCE);
        return String.format("%s is placed into %s's wallet and the amount of gold increases by %d.", this, actor, POT_OF_GOLD_BALANCE);
    }

    /**
     * Allow the actor to consume the Pot of Gold
     * Overrides Item.allowableActions(Actor)
     *
     * @see Item#allowableActions(Actor)
     * @return a list of actions that can be performed on the consumable item Pot of Gold
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
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
            return String.format("%s successfully sold Pot of Gold without earning any credit.", otherActor);
        } else {
            otherActor.addBalance(SELL_CREDIT);
            return String.format("%s successfully sold Pot of Gold for %d credits.", otherActor, SELL_CREDIT);
        }
    }
}
