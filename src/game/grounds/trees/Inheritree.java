package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;

import java.util.List;
import java.util.Random;

/**
 * Abstract base class representing inheritree.
 *
 */
public abstract class Inheritree extends Ground {

    /**
     * The probability of the fruit dropping
     */
    private final double droppingProbability;

    /**
     * Constructor of the Inheritree class.
     *
     * @param displayChar the character that will represent the Inheritree in the display
     * @param droppingProbability a double representing the probability of dropping a fruit.
     */
    public Inheritree(char displayChar, double droppingProbability) {
        super(displayChar);
        this.droppingProbability = droppingProbability;
    }

    /**
     * Drop a fruit.
     *
     * @param location the location to drop the fruit.
     */
    public abstract void dropFruit(Location location);

    /**
     * Drop fruit with a probability.
     *
     * Overrides Ground.tick(Location)
     *
     * @see Ground#tick(Location)
     * @param location The location of the Ground.
     */
    @Override
    public void tick(Location location) {
        List<Exit> exits = location.getExits();
        Location destination = exits.get(Utility.generateRandomInt(0, exits.size())).getDestination();
        if (Math.random() <= droppingProbability) {
            dropFruit(destination);
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
