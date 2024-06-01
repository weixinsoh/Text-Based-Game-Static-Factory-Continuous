package game.scraps.specialscraps.fruits;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface that represents a Fruit Factory used to create new fruit instances in the map
 */
public interface FruitFactory {

    /**
     * Method that can be implemented for dropping fruits
     *
     * @param location Location where the fruit should be dropped
     * @return a boolean that represents whether fruit has been dropped
     */
    boolean drop(Location location);
}
