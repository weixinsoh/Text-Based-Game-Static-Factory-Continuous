package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
/**
 * Interface representing spawner (i.e. the default template for a 'factory' which spawns spawners.)
 *
 */
public interface Spawner {

    /**
     * Method for spawning
     * @param location Location that the new object can be spawned
     */
    void spawn(Location location);
}

