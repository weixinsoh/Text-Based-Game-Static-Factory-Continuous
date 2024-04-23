package game.scraps.fruits;

import game.consumable.ConsumableItem;

/**
 * Abstract base class representing fruit that can be produced by the inheritree.
 *
 */
public abstract class Fruit extends ConsumableItem {
    /**
     * The probability to drop the fruit.
     *
     */
    private final double droppingProbability;

    /***
     * Constructor.
     *
     * @param name the name of the fruit
     * @param displayChar the character to use to represent this fruit if it is on the ground
     * @param droppingProbability the probability of dropping the fruit
        */
    public Fruit(String name, char displayChar, double droppingProbability) {
        super(name, displayChar, true);
        this.droppingProbability = droppingProbability;
    }

    /**
     * Drop the fruit with a probability.
     *
     * @return a boolean indicating the fruit dropped.
     */
    public boolean drop() {
        return Math.random() <= droppingProbability;
    }

}
