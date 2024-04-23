package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.scraps.fruits.Fruit;

import java.util.List;
import java.util.Random;

/**
 * Abstract base class representing inheritree.
 *
 */
public abstract class Inheritree extends Ground {
    /**
     * Random to generate random integer to get random Exit.
     */
    public final Random random = new Random();

    private int count = 0;

    private final int ticksBeforeGrow;

    /**
     * Constructor of the Inheritree class.
     *
     * @param displayChar the character that will represent the Inheritree in the display
     * @param ticksBeforeGrow an integer representing the number of ticks needed to grow to next stage.
     */
    public Inheritree(char displayChar, int ticksBeforeGrow) {
        super(displayChar);
        this.ticksBeforeGrow = ticksBeforeGrow;
    }

    /**
     * Grow a fruit.
     *
     * @return a new fruit.
     */
    public abstract Fruit growFruit();

    /**
     * Return the next stage of the inheritree to grow into.
     *
     * @return the next stage of the inheritree.
     */
    public Inheritree getNextStage() {
        return null;
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

        if (count == ticksBeforeGrow + 1 && getNextStage() != null) {
            location.setGround(getNextStage());
        }

        List<Exit> exits = location.getExits();
        Location destination = exits.get(random.nextInt(exits.size())).getDestination();

        Fruit fruit = growFruit();
        if (fruit.drop()) {
            destination.addItem(fruit);
        }
    }

    /**
     * Set inheritree to block thrown objects.
     *
     * Overrides Ground.blocksThrownObjects()
     *
     * @see Ground#blocksThrownObjects()
     * @return true indicating thrown objects will be blocked.
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
