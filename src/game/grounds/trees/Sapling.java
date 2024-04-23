package game.grounds.trees;

import game.scraps.fruits.Fruit;
import game.scraps.fruits.SmallFruit;

/**
 * Class representing the sapling of the inheritree.
 *
 */
public class Sapling extends Inheritree {
    private static final int TICKS_BEFORE_GROW = 5;

    /**
     * Constructor of the Sapling class.
     *
     */
    public Sapling() {
        super('t', TICKS_BEFORE_GROW);
    }

    /**
     * Grow a small fruit.
     *
     * Overrides Inheritree.growFruit()
     *
     * @see Inheritree#growFruit()
     * @return a new small fruit.
     */
    @Override
    public Fruit growFruit() {
        return new SmallFruit();
    }

    /**
     * Return the MatureTree stage to grow into.
     *
     * Overrides Inheritree.getNextStage()
     *
     * @see Inheritree#getNextStage()
     * @return the MatureTree.
     */
    @Override
    public Inheritree getNextStage() {
        return new MatureTree();
    }
}
