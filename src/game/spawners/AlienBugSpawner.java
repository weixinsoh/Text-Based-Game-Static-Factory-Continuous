package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.creatures.AlienBug;

/**
 * A class that represents an Alien Bug Spawner as it spawns an Alien Bug
 */
public class AlienBugSpawner implements Spawner{

    private static final double ALIEN_BUG_SPAWN_PROBABILITY = 0.1;

    /**
     * The method that spawns a new Alien Bug with a specific probability
     *
     * @param location Location that the Alien Bug can be spawned
     */
    @Override
    public void spawn(Location location) {
        if (Math.random() <= ALIEN_BUG_SPAWN_PROBABILITY) {
            AlienBug alienBug = new AlienBug();
            location.addActor(alienBug);
        }
    }
}
