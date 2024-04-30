package game;

import edu.monash.fit2099.engine.positions.Location;

public interface Spawner {
    /**
     * Interface representing spawner (i.e. the default template for a 'factory' which spawns spawners.)
     *
     */
    void spawn(Location location);
}

