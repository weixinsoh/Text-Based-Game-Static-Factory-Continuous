package game.scraps.fruits;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.consumable.Consumable;

/**
 * Class representing big fruit that can be produced by the mature stage of the inheritree.
 *
 */
public class BigFruit extends Item implements Consumable {

    /**
     * The amount of points it can heal after consuming by the actor.
     *
     */
    public static final int HEAL_POINTS = 2;

    /**
     * Constructor of the BigFruit class.
     *
     */
    public BigFruit() {
        super("big fruit", 'O', true);
    }

    /**
     * Heal the actor after consuming.
     *
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor)
     * @param actor the actor who consumed the healer.
     * @return a string representing the actor consumed the big fruit and the big fruit heals him by point(s).
     */
    public String consumedBy(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.heal(HEAL_POINTS);
        return String.format("%s consumed %s and %s heals %s by %d points. ", actor, this, this, actor, HEAL_POINTS);
    }
}
