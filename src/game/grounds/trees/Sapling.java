package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.scraps.fruits.SmallFruit;

import java.util.List;

/**
 * Class representing the sapling of the inheritree.
 *
 */
public class Sapling extends Inheritree {
    private int count = 0;
    private static final int TICKS_BEFORE_GROW = 5;

    private static final double DROPPING_PROBABILITY = 0.2;
    /**
     * Constructor of the Sapling class.
     *
     */
    public Sapling() {
        super('t', DROPPING_PROBABILITY);
    }

    /**
     * Drop fruit with a probability and grow to next stage after several ticks.
     *
     * Overrides Ground.tick(Location)
     *
     * @see Ground#tick(Location)
     * @param location The location of the Ground.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        count++;

        if (count == TICKS_BEFORE_GROW + 1) {
            location.setGround(new MatureTree());
        }
    }

    /**
     * Drop a small fruit.
     *
     * Overrides Inheritree.dropFruit()
     *
     * @see Inheritree#dropFruit(Location)
     * @param location the location to drop the fruit.
     */
    @Override
    public void dropFruit(Location location) {
        location.addItem(new SmallFruit());
    }
}
