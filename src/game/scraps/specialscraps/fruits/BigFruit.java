package game.scraps.specialscraps.fruits;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.capabilities.Status;
import game.scraps.specialscraps.Sellable;
import game.scraps.specialscraps.Consumable;

/**
 * Class representing big fruit that can be produced by the mature stage of the inheritree.
 *
 */
public class BigFruit extends Item implements Consumable, Sellable {

    private static final int HEAL_POINTS = 2;
    private static final int SELL_CREDIT = 30;

    /**
     * Constructor of the BigFruit class.
     *
     */
    public BigFruit() {
        super("large fruit", 'O', true);
    }

    /**
     * Heal the actor after consuming and removes the fruit from the actor's inventory
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor, GameMap)
     * @param actor the actor who consumes the Big Fruit
     * @return a string representing the actor has consumed the big fruit and the amount the big fruit has healed the actor
     */
    @Override
    public String consumedBy(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        actor.heal(HEAL_POINTS);
        return String.format("%s consumed %s and %s heals %s by %d points. ", actor, this, this, actor, HEAL_POINTS);
    }

    /**
     * Allow the actor to consume the Big Fruit.
     * Overrides Item.allowableActions(Actor)
     *
     * @see Item#allowableActions(Actor)
     * @return a list of actions that can be performed on the Big Fruit.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Allows the actor with big fruit to sell the big fruit to another actor
     * if that actor has the BUYER status
     * Overrides Item.allowableActions(Actor otherActor, Location location)
     *
     * @param otherActor the other actor that the actor with big fruit is next to
     * @param location the location of the other actor
     * @return a list of allowable actions that can be taken
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.BUYER)){
            actions.add(new SellAction(this));
        }
        return actions;
    }

    /**
     * Sell a big fruit with a certain credit and remove it from the actor's item inventory.
     *
     * @see Sellable#sell(Actor, GameMap)
     * @param otherActor The actor who sold the big fruit.
     * @param map The map the actor is on.
     * @return a string representing the actor sold the big fruit with a certain credit.
     */
    @Override
    public String sell(Actor otherActor, GameMap map) {
        otherActor.addBalance(SELL_CREDIT);
        otherActor.removeItemFromInventory(this);
        return String.format("%s successfully sold Large Fruit for %d credits.", otherActor, SELL_CREDIT);
    }
}
