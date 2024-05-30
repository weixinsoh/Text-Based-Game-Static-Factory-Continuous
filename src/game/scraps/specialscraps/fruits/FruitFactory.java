package game.scraps.specialscraps.fruits;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface that represents a Fruit Factory used to create new fruit instances in the map
 */
public interface FruitFactory {
    boolean drop(Location location);
}
