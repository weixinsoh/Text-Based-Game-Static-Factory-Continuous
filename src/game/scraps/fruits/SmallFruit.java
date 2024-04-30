package game.scraps.fruits;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.consumable.Consumable;

/**
 * Class representing small fruit that can be produced by the sapling of the inheritree.
 *
 */
public class SmallFruit extends Item implements Consumable {
    /**
     * The probability to drop the fruit.
     *
     */
    public static final double DROPPING_PROBABILITY = 0.2;

    /**
     * The amount of points it can heal after consuming by the actor.
     *
     */
    public static final int HEAL_POINTS = 1;

    /**
     * Constructor of the SmallFruit class.
     *
     */
    public SmallFruit() {
        super("small fruit", 'o', true);
    }

    /**
     * Heal the actor after consuming.
     *
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor)
     * @param actor the actor who consumed the healer.
     * @return a string representing the actor consumed the small fruit and the small fruit heals him by point(s).
     */
    public String consumedBy(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.heal(HEAL_POINTS);
        return String.format("%s consumed %s and %s heals %s by %d points. ", actor, this, this, actor, HEAL_POINTS);
    }

}
