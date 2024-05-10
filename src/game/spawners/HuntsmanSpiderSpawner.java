package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.creatures.HuntsmanSpider;

/**
 * A class that represents a Huntsman Spider Spawner as it spawns a Huntsman Spider
 */
public class HuntsmanSpiderSpawner implements Spawner {

    private static final double HUNTSMAN_SPIDER_SPAWN_PROBABILITY = 0.05;

    /**
     * The method that spawns a new Huntsman Spider with a specific probability
     *
     * @param location Location that the Huntsman Spider can be spawned
     */
    @Override
    public void spawn(Location location) {
        if (Math.random() <= HUNTSMAN_SPIDER_SPAWN_PROBABILITY) {
            HuntsmanSpider hunstmanSpider = new HuntsmanSpider();
            location.addActor(hunstmanSpider);
        }

    }
}
