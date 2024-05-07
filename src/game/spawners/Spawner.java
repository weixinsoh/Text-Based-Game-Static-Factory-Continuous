package game.spawners;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.creatures.Creature;

public interface Spawner {
    /**
     * Interface representing spawner (i.e. the default template for a 'factory' which spawns spawners.)
     *
     */
    void spawn(Location location);
}

