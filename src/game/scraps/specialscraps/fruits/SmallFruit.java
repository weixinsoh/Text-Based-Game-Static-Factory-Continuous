package game.scraps.specialscraps.fruits;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.scraps.specialscraps.Consumable;

/**
 * Class representing small fruit that can be produced by the sapling of the inheritree.
 *
 */
public class SmallFruit extends Item implements Consumable {

    private static final int HEAL_POINTS = 1;

    /**
     * Constructor of the SmallFruit class.
     *
     */
    public SmallFruit() {
        super("small fruit", 'o', true);
    }

    /**
     * Heal the actor after consuming and removes the fruit from the actor's inventory
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor, GameMap)
     * @param actor the actor who consumed the healer.
     * @return a string representing the actor consumed the small fruit and the amount small fruit has healed the actor.
     */
    @Override
    public String consumedBy(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        actor.heal(HEAL_POINTS);
        return String.format("%s consumed %s and %s heals %s by %d points. ", actor, this, this, actor, HEAL_POINTS);
    }

    /**
     * Allow the actor to consume the Small Fruit.
     * Overrides Item.allowableActions(Actor)
     *
     * @see Item#allowableActions(Actor)
     * @return a list of actions that can be performed on the Small Fruit.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

}