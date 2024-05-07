package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.scraps.specialscraps.fruits.BigFruit;

/**
 * Class representing the mature stage of the inheritree.
 *
 */
public class MatureTree extends Inheritree {
    /**
     * The probability to drop the fruit.
     *
     */
    private static final double DROPPING_PROBABILITY = 0.3;

    /**
     * Constructor of the MatureTree class.
     *
     */
    public MatureTree() {
        super('T', DROPPING_PROBABILITY);
    }

    /**
     * Drop a big fruit.
     *
     * Overrides Inheritree.dropFruit(Location)
     *
     * @see Inheritree#dropFruit(Location)
     * @param location the location to drop the fruit.
     */
    @Override
    public void dropFruit(Location location) {
        location.addItem(new BigFruit());
    }
}
