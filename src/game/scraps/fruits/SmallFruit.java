package game.scraps.fruits;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Class representing small fruit that can be produced by the sapling of the inheritree.
 *
 */
public class SmallFruit extends Fruit {
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
        super("small fruit", 'o', DROPPING_PROBABILITY);
    }

    /**
     * Heal the actor after consuming.
     *
     *
     * @param actor the actor who consumed the healer.
     * @return a string representing the actor consumed the small fruit and the small fruit heals him by point(s).
     */
    public String consumedBy(Actor actor) {
        actor.heal(HEAL_POINTS);
        return String.format("%s and %s heals %s by %d points. ", super.consumedBy(actor), this, actor, HEAL_POINTS);
    }

}
